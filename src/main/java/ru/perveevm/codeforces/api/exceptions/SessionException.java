package ru.perveevm.codeforces.api.exceptions;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class SessionException extends Exception {
    public SessionException(final String message) {
        super(message);
    }

    public SessionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    protected static String getMessage(final String url, final List<NameValuePair> parameters) {
        return String.format("Error happened while performing POST request to %s with parameters %s", url,
                parameters.stream()
                        .map(param -> String.format("\"%s\": \"%s\"", param.getName(), param.getValue()))
                        .collect(Collectors.joining(", ", "{", "}")));
    }
}
