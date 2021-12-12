package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

public class SessionHTTPErrorException extends SessionException {
    public SessionHTTPErrorException(final String url, final List<NameValuePair> parameters) {
        super(getMessage(url, parameters));
    }

    public SessionHTTPErrorException(final String url, final List<NameValuePair> parameters, final Throwable cause) {
        super(getMessage(url, parameters), cause);
    }
}
