package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a contest phase.
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
