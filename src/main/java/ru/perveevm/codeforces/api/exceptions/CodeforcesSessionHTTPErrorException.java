package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Thrown when a HTTP error occured while sendings POST request.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class CodeforcesSessionHTTPErrorException extends CodeforcesSessionException {
    /**
     * Constructs {@link CodeforcesSessionHTTPErrorException} using request URL and parameters.
     *
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     */
    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters) {
        super(getMessage(url, parameters));
    }

    /**
     * Constructs {@link CodeforcesSessionHTTPErrorException} using request URL, parameters and cause exception.
     *
     * @param url        Request URL.
     * @param parameters A {@link List} of parameters.
     * @param cause      Cause of this exception.
     */
    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters,
                                               final Throwable cause) {
        super(getMessage(url, parameters), cause);
    }
}
