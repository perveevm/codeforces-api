package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

public class SessionBadResponseException extends SessionException {
    public SessionBadResponseException(final String url, final List<NameValuePair> parameters, final int responseCode) {
        super(getMessage(url, parameters) + String.format(", response code is %d", responseCode));
    }

    public SessionBadResponseException(final String url, final List<NameValuePair> parameters, final int responseCode,
                                       final Throwable cause) {
        super(getMessage(url, parameters) + String.format(", response code is %d", responseCode), cause);
    }

    public SessionBadResponseException(final String url, final List<NameValuePair> parameters) {
        super(getMessage(url, parameters) + ", cannot parse response");
    }

    public SessionBadResponseException(final String url, final List<NameValuePair> parameters, final Throwable cause) {
        super(getMessage(url, parameters) + ", cannot parse response", cause);
    }
}
