package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Thrown when an error occures while interacting with CodeForces API.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class CodeforcesSessionException extends Exception {
    /**
     * Constructs {@link CodeforcesSessionException} using error message.
     *
     * @param message Error message.
     */
    public CodeforcesSessionException(final String message) {
        super(message);
    }

    /**
     * Constructs {@link CodeforcesSessionException} using error message and cause exception.
     *
     * @param message Error message.
     * @param cause   Cause of this exception.
     */
    public CodeforcesSessionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Generates a human-readable error message that contains request URL and parameters.
     * API key and secret are hidden for security reasons.
     *
     * @param url        Request URL.
     * @param parameters Request parameters.
     * @return
     */
    protected static String getMessage(final String url, final List<NameValuePair> parameters) {
        return String.format("Error happened while performing POST request to %s with parameters %s", url,
                parameters.stream()
                        .map(param -> {
                            if (param.getName().equals("apiKey") || param.getName().equals("apiSig")) {
                                return new BasicNameValuePair(param.getName(), "Hidden for security");
                            } else {
                                return param;
                            }
                        })
                        .map(param -> String.format("\"%s\": \"%s\"", param.getName(), param.getValue()))
                        .collect(Collectors.joining(", ", "{", "}")));
    }
}
