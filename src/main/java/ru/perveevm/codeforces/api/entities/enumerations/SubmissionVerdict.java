package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a submission status.
 */
public enum SubmissionVerdict {
    /**
     * Checking was failed by some reason.
     */
    FAILED,
    /**
     * Solution is correct and passed all the tests.
     */
    OK,
    /**
     * Partial solution, for IOI-style contests.
     */
    PARTIAL,
    /**
     * Cannot compile solution.
     */
    COMPILATION_ERROR,
    /**
     * Solution crashed with non-zero exit code.
     */
    RUNTIME_ERROR,
    /**
     * Solution gives wrong answer for some tests.
     */
    WRONG_ANSWER,
    /**
     * Output format of solution is wrong.
     */
    PRESENTATION_ERROR,
    /**
     * Solution is too slow.
     */
    TIME_LIMIT_EXCEEDED,
    /**
     * Solution uses too many memory.
     */
    MEMORY_LIMIT_EXCEEDED,
    /**
     * Solution doesn't read or write data.
     */
    IDLENESS_LIMIT_EXCEEDED,
    /**
     * Solution tries to disrupt the system.
     */
    SECURITY_VIOLATED,
    /**
     * Checking was crashed for some reason.
     */
    CRASHED,
    /**
     * Input preparation was crashed for some reason.
     */
    INPUT_PREPARATION_CRASHED,
    /**
     * The solution was successfully hacked.
     */
    CHALLENGED,
    /**
     * Testing of the solution was skipped.
     */
    SKIPPED,
    /**
     * Solution is being tested.
     */
    TESTING,
    /**
     * Solution is rejected by some reason.
     */
    REJECTED
}
