package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Thrown when the response JSON status is FAILED.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class CodeforcesSessionFailedRequestException extends CodeforcesSessionException {
    /**
     * Constructs {@link CodeforcesSessionFailedRequestException} using request URL, parameters and response comment.
     *
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     * @param comment    A response comment from JSON.
     */
    public CodeforcesSessionFailedRequestException(final String url, final List<NameValuePair> parameters,
                                                   final String comment) {
        super(getMessage(url, parameters) + String.format(" returned status is FAILED, comment: %s", comment));
    }

    /**
     * Constructs {@link CodeforcesSessionFailedRequestException} using request URL, parameters, response comment
     * and cause exception.
     *
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     * @param comment    A response comment from JSON.
     * @param cause      An exception cause.
     */
    public CodeforcesSessionFailedRequestException(final String url, final List<NameValuePair> parameters,
                                                   final String comment, final Throwable cause) {
        super(getMessage(url, parameters) + String.format(" returned status is FAILED, comment: %s", comment), cause);
    }
}
