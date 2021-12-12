package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

public class CodeforcesSessionHTTPErrorException extends CodeforcesSessionException {
    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters) {
        super(getMessage(url, parameters));
    }

    public CodeforcesSessionHTTPErrorException(final String url, final List<NameValuePair> parameters, final Throwable cause) {
        super(getMessage(url, parameters), cause);
    }
}
