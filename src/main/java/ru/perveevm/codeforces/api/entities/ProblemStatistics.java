package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a statistic data about a problem.
 */
public class ProblemStatistics {
    private Integer contestId;
    private String index;
    private Integer solvedCount;

    /**
     * @return Can be <code>null</code>. ID of the contest, containing the problem.
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * @return Usually, a letter or letter with digit(s) indicating the problem index in a contest.
     */
    public String getIndex() {
        return index;
    }

    /**
     * @return Number of users, who solved the problem.
     */
    public Integer getSolvedCount() {
        return solvedCount;
    }
}
