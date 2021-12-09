package ru.perveevm.codeforces.api;

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
}
