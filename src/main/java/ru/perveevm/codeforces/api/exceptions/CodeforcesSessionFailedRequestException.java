package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Thrown when the response JSON status is FAILED.
 */
public class CodeforcesSessionFailedRequestException extends CodeforcesSessionException {
    /**
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     * @param comment    A response comment from JSON.
     */
    public CodeforcesSessionFailedRequestException(final String url, final List<NameValuePair> parameters,
                                                   final String comment) {
        super(getMessage(url, parameters) + String.format(" returned status is FAILED, comment: %s", comment));
    }

    /**
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
