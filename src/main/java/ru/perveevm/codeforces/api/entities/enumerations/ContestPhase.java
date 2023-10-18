package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * Represents a contest phase.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public enum ContestPhase {
    /**
     * Before the contest begins.
     */
    BEFORE,
    /**
     * Contest is running.
     */
    CODING,
    /**
     * Waiting for system testing.
     */
    PENDING_SYSTEM_TEST,
    /**
     * Running the system tests.
     */
    SYSTEM_TEST,
    /**
     * Contest is finished.
     */
    FINISHED
}
