package ru.perveevm.codeforces.api.json;

/**
 * Describes JSON response status.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public enum JSONResponseStatus {
    /**
     * Request completed, response is good.
     */
    OK,
    /**
     * Request was invalid or wasn't able to be completed for some reason.
     */
    FAILED
}
