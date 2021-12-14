package ru.perveevm.codeforces.api.json;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 *
 * Describes JSON response status.
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
