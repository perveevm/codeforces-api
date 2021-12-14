package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Thrown when a HTTP error occured while sendings POST request.
 */
public class CodeforcesSessionHTTPErrorException extends CodeforcesSessionException {
    /**
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     */
    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters) {
        super(getMessage(url, parameters));
    }

    /**
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     * @param cause      Cause of this exception.
     */
    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters,
                                               final Throwable cause) {
        super(getMessage(url, parameters), cause);
    }
}
