package ru.perveevm.codeforces.api.entities;

/**
 * Represents an information about problems in a problemset.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class ProblemsetProblems {
    private Problem[] problems;
    private ProblemStatistics[] problemStatistics;

    /**
     * Constructs {@link ProblemsetProblems} using problems and their statistics.
     *
     * @param problems          The array of {@link Problem} objects.
     * @param problemStatistics The array of {@link ProblemStatistics} objects.
     */
    public ProblemsetProblems(Problem[] problems, ProblemStatistics[] problemStatistics) {
        this.problems = problems;
        this.problemStatistics = problemStatistics;
    }

    /**
     * @return Array of {@link Problem} objects in the problemset.
     */
    public Problem[] getProblems() {
        return problems;
    }

    /**
     * @return Array of {@link ProblemStatistics} for each problem in the problemset.
     */
    public ProblemStatistics[] getProblemStatistics() {
        return problemStatistics;
    }
}
