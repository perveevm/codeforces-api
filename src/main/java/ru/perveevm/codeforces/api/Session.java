package ru.perveevm.codeforces.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import lombok.NonNull;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import ru.perveevm.codeforces.api.entities.*;
import ru.perveevm.codeforces.api.json.JSONResponse;
import ru.perveevm.codeforces.api.json.JSONResponseStatus;
import ru.perveevm.codeforces.api.utils.Pair;
import ru.perveevm.codeforces.api.utils.ReflectionUtils;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class Session implements Closeable {
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final static String BASE_URL = "https://codeforces.com/api/";

    private final String key;
    private final String secret;
    private Language lang = Language.EN;

    private final Random random = new Random();
    private final CloseableHttpClient client = HttpClients.createDefault();
    private final Gson gson = new Gson();

    public Session(final String key, final String secret) {
        this.key = key;
        this.secret = secret;
    }

    public void setLang(final Language lang) {
        this.lang = lang;
    }

    @Override
    public void close() throws IOException {
        client.close();
    }

    public Comment[] blogEntryComments(@NonNull final Integer blogEntryId) throws SessionException {
        return gson.fromJson(sendAPIRequest("blogEntryComments", "blogEntry.comments", blogEntryId), Comment[].class);
    }

    public BlogEntry blogEntryView(@NonNull final Integer blogEntryId) throws SessionException {
        return gson.fromJson(sendAPIRequest("blogEntryView", "blogEntry.view", blogEntryId), BlogEntry.class);
    }

    public Hack[] contestHacks(@NonNull final Integer contestId) throws SessionException {
        return gson.fromJson(sendAPIRequest("contestHacks", "contest.hacks", contestId), Hack[].class);
    }

    public Contest[] contestList(final Boolean gym) throws SessionException {
        return gson.fromJson(sendAPIRequest("contestList", "contest.list", gym), Contest[].class);
    }

    public RatingChange[] contestRatingChanges(@NonNull final Integer contestId) throws SessionException {
        return gson.fromJson(sendAPIRequest("contestRatingChanges", "contest.ratingChanges", contestId),
                RatingChange[].class);
    }

    public ContestStandings contestStandings(@NonNull final Integer contestId, final Integer from,
                                             final Integer count, final String handles, final Integer room,
                                             final Boolean showUnofficial) throws SessionException {
        return gson.fromJson(sendAPIRequest("contestStandings", "contest.standings", contestId, from, count,
                handles, room, showUnofficial), ContestStandings.class);
    }

    public Submission[] contestStatus(@NonNull final Integer contestId, final String handle,
                                      final Integer from, final Integer count) throws SessionException {
        return gson.fromJson(sendAPIRequest("contestStatus", "contest.status", contestId, handle,
                from, count), Submission[].class);
    }

    public Pair<Problem[], ProblemStatistics[]> problemsetProblems(final String tags, final String problemsetName)
            throws SessionException {
        JsonElement response = sendAPIRequest("problemsetProblems", "problemset.problems", tags, problemsetName);
        JsonElement problems = response.getAsJsonObject().get("problems");
        JsonElement problemStatistics = response.getAsJsonObject().get("problemStatistics");
        return new Pair<>(gson.fromJson(problems, Problem[].class), gson.fromJson(problemStatistics,
                ProblemStatistics[].class));
    }

    public Submission[] problemsetRecentStatus(@NonNull final Integer count, final String problemsetName)
            throws SessionException {
        return gson.fromJson(sendAPIRequest("problemsetRecentStatus", "problemset.recentStatus", count,
                problemsetName), Submission[].class);
    }

    public RecentAction[] recentActions(@NonNull final Integer maxCount) throws SessionException {
        return gson.fromJson(sendAPIRequest("recentActions", "recentActions", maxCount), RecentAction[].class);
    }

    public BlogEntry[] userBlogEntries(@NonNull final String handle) throws SessionException {
        return gson.fromJson(sendAPIRequest("userBlogEntries", "user.blogEntries", handle), BlogEntry[].class);
    }

    public String[] userFriends(final Boolean onlyOnline) throws SessionException {
        return gson.fromJson(sendAPIRequest("userFriends", "user.friends", onlyOnline), String[].class);
    }

    public User[] userInfo(@NonNull final String handles) throws SessionException {
        return gson.fromJson(sendAPIRequest("userInfo", "user.info", handles), User[].class);
    }

    public User[] userRatedList(final Boolean activeOnly) throws SessionException {
        return gson.fromJson(sendAPIRequest("userRatedList", "user.ratedList", activeOnly), User[].class);
    }

    public RatingChange[] userRating(@NonNull final String handle) throws SessionException {
        return gson.fromJson(sendAPIRequest("userRating", "user.rating", handle), RatingChange[].class);
    }

    public Submission[] userStatus(@NonNull final String handle, final Integer from, final Integer count)
            throws SessionException {
        return gson.fromJson(sendAPIRequest("userStatus", "user.status", handle, from, count), Submission[].class);
    }

    private JsonElement sendAPIRequest(final String method, final String methodName, final Object... values)
            throws SessionException {
        List<NameValuePair> parameters = ReflectionUtils.encodeMethodParameters(
                ReflectionUtils.getMethodByName(this.getClass(), method), values);
        return sendAPIRequest(methodName, parameters);
    }

    private JsonElement sendAPIRequest(final String methodName, final List<NameValuePair> parameters)
            throws SessionException {
        List<NameValuePair> extendedParameters = new ArrayList<>(parameters);
        switch (lang) {
            case EN -> extendedParameters.add(new BasicNameValuePair("lang", "en"));
            case RU -> extendedParameters.add(new BasicNameValuePair("lang", "ru"));
        }
        extendedParameters.add(new BasicNameValuePair("apiKey", key));
        extendedParameters.add(new BasicNameValuePair("time", String.valueOf(System.currentTimeMillis() / 1000)));
        extendedParameters.add(new BasicNameValuePair("apiSig", generateApiSig(methodName, extendedParameters)));

        HttpResponse response;
        try {
            response = sendPostRequest(BASE_URL + methodName, extendedParameters);
        } catch (IOException e) {
            throw new SessionException("Error happened while sending POST request: " + e.getMessage(), e);
        }

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new SessionException("Error happened while sending POST request, status code: "
                    + response.getStatusLine().getStatusCode() + ", reason: "
                    + response.getStatusLine().getReasonPhrase());
        }

        String json;
        try {
            json = EntityUtils.toString(response.getEntity());
        } catch (IOException | ParseException e) {
            throw new SessionException("Error happened while parsing server response: " + e.getMessage(), e);
        }

        JSONResponse jsonResponse = gson.fromJson(json, JSONResponse.class);
        if (jsonResponse.getStatus() == JSONResponseStatus.FAILED) {
            throw new SessionException("Failed to perform request, server comment: " + jsonResponse.getComment());
        }

        return jsonResponse.getResult();
    }

    private HttpResponse sendPostRequest(final String url, final List<NameValuePair> parameters)
            throws IOException {
        HttpPost request = new HttpPost(url);
        request.setEntity(new UrlEncodedFormEntity(parameters));
        return client.execute(request);
    }

    private String generateApiSig(final String methodName, final List<NameValuePair> parameters) {
        StringBuilder rand = new StringBuilder();
        StringBuilder apiSig = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            rand.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }

        apiSig.append(rand).append('/').append(methodName).append('?').append(parameters.stream()
                .sorted(Comparator.comparing(NameValuePair::getName).thenComparing(NameValuePair::getValue))
                .map(p -> p.getName() + "=" + p.getValue())
                .collect(Collectors.joining("&"))).append('#').append(secret);

        rand.append(DigestUtils.sha512Hex(apiSig.toString()));
        return rand.toString();
    }
}
