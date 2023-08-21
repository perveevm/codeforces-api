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
import ru.perveevm.codeforces.api.entities.enumerations.Language;
import ru.perveevm.codeforces.api.exceptions.CodeforcesSessionBadResponseException;
import ru.perveevm.codeforces.api.exceptions.CodeforcesSessionException;
import ru.perveevm.codeforces.api.exceptions.CodeforcesSessionFailedRequestException;
import ru.perveevm.codeforces.api.exceptions.CodeforcesSessionHTTPErrorException;
import ru.perveevm.codeforces.api.json.JSONResponse;
import ru.perveevm.codeforces.api.json.JSONResponseStatus;
import ru.perveevm.codeforces.api.utils.Pair;
import ru.perveevm.codeforces.api.utils.ReflectionUtils;

import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * This class performs CodeForces API calls and parses resonse into corresponding entities.
 * All methods are named accordingly to <a href="https://codeforces.com/apiHelp">CodeForces API help page</a>
 * <p>
 * {@link CodeforcesSessionException} is thrown when request parameters are invalid or the requests are sent too often
 * or CodeForces API is unavailable by any other reason.
 */
public class CodeforcesSession implements Closeable {
    private final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private final static String BASE_URL = "https://codeforces.com/api/";

    private final String key;
    private final String secret;
    private Language lang = Language.EN;

    private final Random random = new Random();
    private final CloseableHttpClient client = HttpClients.createDefault();
    private final Gson gson = new Gson();

    /**
     * @param key    CodeForces API <code>key</code>
     * @param secret CodeForces API <code>secret</code>
     */
    public CodeforcesSession(final String key, final String secret) {
        this.key = key;
        this.secret = secret;
    }

    /**
     * Sets response language
     *
     * @param lang new response language
     */
    public void setLang(final Language lang) {
        this.lang = lang;
    }

    @Override
    public void close() throws IOException {
        client.close();
    }

    /**
     * Returns a list of comments to the specified blog entry.
     *
     * @param blogEntryId ID of the blog entry. It can be seen in blog entry URL.
     * @return An array of {@link  Comment} objects.
     */
    public Comment[] blogEntryComments(@NonNull final Integer blogEntryId) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("blogEntryComments", "blogEntry.comments", blogEntryId), Comment[].class);
    }

    /**
     * Returns blog entry.
     *
     * @param blogEntryId ID of the blog entry. It can be seen in blog entry URL.
     * @return A {@link BlogEntry} object in full version.
     */
    public BlogEntry blogEntryView(@NonNull final Integer blogEntryId) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("blogEntryView", "blogEntry.view", blogEntryId), BlogEntry.class);
    }

    /**
     * Returns list of hacks in the specified contests.
     * Full information about hacks is available only after some time after the contest end.
     * During the contest user can see only own hacks.
     *
     * @param contestId ID of the contest. It is <b>not</b> the round number. It can be seen in contest URL.
     * @param asManager If set to <code>true</code>, the response will contain information available to contest managers.
     *                  Otherwise, the response will contain only the information available to the participants.
     *                  You must be a contest manager to use it.
     * @return An array of {@link Hack} objects.
     */
    public Hack[] contestHacks(@NonNull final Integer contestId, final Boolean asManager) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("contestHacks", "contest.hacks", contestId, asManager), Hack[].class);
    }

    /**
     * Returns information about all available contests.
     *
     * @param gym If <code>true</code> — than gym contests are returned. Otherwise, regular contests are returned.
     * @return An array of {@link Contest} objects.
     * All available contests for a calling user will be returned too, including mashups and private gyms.
     */
    public Contest[] contestList(final Boolean gym) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("contestList", "contest.list", gym), Contest[].class);
    }

    /**
     * Returns rating changes after the contest.
     *
     * @param contestId ID of the contest. It is <b>not</b> the round number. It can be seen in contest URL.
     * @return An array of {@link RatingChange} objects.
     */
    public RatingChange[] contestRatingChanges(@NonNull final Integer contestId) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("contestRatingChanges", "contest.ratingChanges", contestId),
                RatingChange[].class);
    }

    /**
     * Returns the description of the contest and the requested part of the standings.
     *
     * @param contestId      ID of the contest. It is <b>not</b> the round number. It can be seen in contest URL.
     * @param asManager      If set to <code>true</code>, the response will contain information available to contest
     *                       managers. Otherwise, the response will contain only the information available to the
     *                       participants. You must be a contest manager to use it.
     * @param from           1-based index of the standings row to start the ranklist.
     * @param count          Number of standing rows to return.
     * @param handles        Array of handles. No more than 10000 handles is accepted.
     * @param room           If specified, then only participants from this room will be shown in the result.
     *                       If not — all the participants will be shown.
     * @param showUnofficial If true then all participants (virtual, out of competition) are shown.
     *                       Otherwise, only official contestants are shown.
     * @return A {@link ContestStandings} object.
     */
    public ContestStandings contestStandings(@NonNull final Integer contestId, final Boolean asManager,
                                             final Integer from, final Integer count, final String[] handles,
                                             final Integer room, final Boolean showUnofficial)
            throws CodeforcesSessionException {
        String joinedHandles = (handles != null ? String.join(";", handles) : null);
        return gson.fromJson(sendAPIRequest("contestStandings", "contest.standings", contestId,
                asManager, from, count, joinedHandles, room, showUnofficial), ContestStandings.class);
    }

    /**
     * Returns submissions for specified contest. Optionally can return submissions of specified user.
     *
     * @param contestId ID of the contest. It is <b>not</b> the round number. It can be seen in contest URL.
     * @param asManager If set to <code>true</code>, the response will contain information available to contest
     *                  managers. Otherwise, the response will contain only the information available to the
     *                  participants. You must be a contest manager to use it.
     * @param handle    Codeforces user handle.
     * @param from      1-based index of the first submission to return.
     * @param count     Number of returned submissions.
     * @return An array of {@link Submission} objects sorted in decreasing order of submission id.
     */
    public Submission[] contestStatus(@NonNull final Integer contestId, final Boolean asManager, final String handle,
                                      final Integer from, final Integer count) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("contestStatus", "contest.status", contestId, asManager,
                handle, from, count), Submission[].class);
    }

    /**
     * Returns all problems from problemset. Problems can be filtered by tags.
     *
     * @param tags           An array of tags.
     * @param problemsetName Custom problemset's short name, like 'acmsguru'
     * @return An array of {@link Problem} objects and an array of {@link ProblemStatistics} objects.
     */
    public Pair<Problem[], ProblemStatistics[]> problemsetProblems(final String[] tags, final String problemsetName)
            throws CodeforcesSessionException {
        String joinedTags = (tags != null ? String.join(";", tags) : null);
        JsonElement response = sendAPIRequest("problemsetProblems", "problemset.problems", joinedTags,
                problemsetName);
        JsonElement problems = response.getAsJsonObject().get("problems");
        JsonElement problemStatistics = response.getAsJsonObject().get("problemStatistics");
        return new Pair<>(gson.fromJson(problems, Problem[].class), gson.fromJson(problemStatistics,
                ProblemStatistics[].class));
    }

    /**
     * Returns recent submissions.
     *
     * @param count          Number of submissions to return. Can be up to 1000.
     * @param problemsetName Custom problemset's short name, like 'acmsguru'
     * @return An array of {@link Submission} objects.
     */
    public Submission[] problemsetRecentStatus(@NonNull final Integer count, final String problemsetName)
            throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("problemsetRecentStatus", "problemset.recentStatus", count,
                problemsetName), Submission[].class);
    }

    /**
     * Returns recent actions.
     *
     * @param maxCount Number of recent actions to return. Can be up to 100.
     * @return An array of {@link RecentAction} objects.
     */
    public RecentAction[] recentActions(@NonNull final Integer maxCount) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("recentActions", "recentActions", maxCount), RecentAction[].class);
    }

    /**
     * Returns a list of all user's blog entries.
     *
     * @param handle Codeforces user handle.
     * @return An array of {@link BlogEntry} objects in a short form.
     */
    public BlogEntry[] userBlogEntries(@NonNull final String handle) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userBlogEntries", "user.blogEntries", handle), BlogEntry[].class);
    }

    /**
     * Returns authorized user's friends.
     *
     * @param onlyOnline If <code>true</code> — only online friends are returned. Otherwise, all friends are returned.
     * @return An array of {@link String} objects — users' handles.
     */
    public String[] userFriends(final Boolean onlyOnline) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userFriends", "user.friends", onlyOnline), String[].class);
    }

    /**
     * Returns information about one or several users.
     *
     * @param handles An array of handles. No more than 10000 handles is accepted.
     * @return An array of {@link User} objects for requested handles.
     */
    public User[] userInfo(@NonNull final String[] handles) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userInfo", "user.info", String.join(";", handles)), User[].class);
    }

    /**
     * Returns the list users who have participated in at least one rated contest.
     *
     * @param activeOnly     If <code>true</code> then only users, who participated in rated contest during the last month
     *                   are returned. Otherwise, all users with at least one rated contest are returned.
     * @param includeRetired If <code>true</code>, the method returns all rated users, otherwise the method returns
     *                       only users, that were online at last month.
     * @param contestId      Id of the contest. It is <b>not</b> the round number. It can be seen in contest URL.
     * @return An array of {@link User} objects, sorted in decreasing order of rating.
     */
    public User[] userRatedList(final Boolean activeOnly, final Boolean includeRetired, final Integer contestId)
            throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userRatedList", "user.ratedList", activeOnly,
                includeRetired, contestId), User[].class);
    }

    /**
     * Returns rating history of the specified user.
     *
     * @param handle Codeforces user handle.
     * @return An array of {@link RatingChange} objects for requested user.
     */
    public RatingChange[] userRating(@NonNull final String handle) throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userRating", "user.rating", handle), RatingChange[].class);
    }

    /**
     * Returns submissions of specified user.
     *
     * @param handle Codeforces user handle.
     * @param from   1-based index of the first submission to return.
     * @param count  Number of returned submissions.
     * @return An array of {@link Submission} objects, sorted in decreasing order of submission id.
     */
    public Submission[] userStatus(@NonNull final String handle, final Integer from, final Integer count)
            throws CodeforcesSessionException {
        return gson.fromJson(sendAPIRequest("userStatus", "user.status", handle, from, count), Submission[].class);
    }

    private JsonElement sendAPIRequest(final String method, final String methodName, final Object... values)
            throws CodeforcesSessionException {
        List<NameValuePair> parameters = ReflectionUtils.encodeMethodParameters(
                ReflectionUtils.getMethodByName(this.getClass(), method), values);
        return sendAPIRequest(methodName, parameters);
    }

    private JsonElement sendAPIRequest(final String methodName, final List<NameValuePair> parameters)
            throws CodeforcesSessionException {
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
            throw new CodeforcesSessionHTTPErrorException(BASE_URL + methodName, extendedParameters, e);
        }

        String json;
        try {
            json = EntityUtils.toString(response.getEntity());
        } catch (IOException | ParseException e) {
            throw new CodeforcesSessionBadResponseException(BASE_URL + methodName, extendedParameters,
                    response.getStatusLine().getStatusCode(), e);
        }

        JSONResponse jsonResponse = gson.fromJson(json, JSONResponse.class);
        if (jsonResponse.getStatus() == JSONResponseStatus.FAILED) {
            throw new CodeforcesSessionFailedRequestException(BASE_URL + methodName, extendedParameters,
                    jsonResponse.getComment());
        }

        return jsonResponse.getResult();
    }

    private HttpResponse sendPostRequest(final String url, final List<NameValuePair> parameters)
            throws IOException {
        HttpPost request = new HttpPost(url);
        request.setEntity(new UrlEncodedFormEntity(parameters, StandardCharsets.UTF_8));
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
