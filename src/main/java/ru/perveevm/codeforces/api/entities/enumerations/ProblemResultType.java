package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a problem result type.
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
