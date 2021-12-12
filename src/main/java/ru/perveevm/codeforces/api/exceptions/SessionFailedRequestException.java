package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;

public class SessionFailedRequestException extends SessionException {
    public SessionFailedRequestException(final String url, final List<NameValuePair> parameters, final String comment) {
        super(getMessage(url, parameters) + String.format(" returned status is FAILED, comment: %s", comment));
    }

    public SessionFailedRequestException(final String url, final List<NameValuePair> parameters, final String comment,
                                         final Throwable cause) {
        super(getMessage(url, parameters) + String.format(" returned status is FAILED, comment: %s", comment), cause);
    }
}
