package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * Represents a problem result type.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public enum ProblemResultType {
    /**
     * The result is not final, it may change.
     */
    PRELIMINARY,
    /**
     * The result is final and it may not change.
     */
    FINAL
}
