package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * Represents a hack verdict.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public enum HackVerdict {
    /**
     * Hack was successful.
     */
    HACK_SUCCESSFUL,
    /**
     * Hack was unsuccessful.
     */
    HACK_UNSUCCESSFUL,
    /**
     * Test input is invalid.
     */
    INVALID_INPUT,
    /**
     * Cannot compile generator.
     */
    GENERATOR_INCOMPILABLE,
    /**
     * Generator crashed while generating test input.
     */
    GENERATOR_CRASHED,
    /**
     * Hack was ignored.
     */
    IGNORED,
    /**
     * Hack is testing.
     */
    TESTING,
    /**
     * Some other verdict.
     */
    OTHER
}
