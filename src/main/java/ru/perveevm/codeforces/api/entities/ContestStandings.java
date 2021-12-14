package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents contest standings.
 */
public class ContestStandings {
    private Contest contest;
    private Problem[] problems;
    private RanklistRow[] rows;

    /**
     * @return A {@link Contest} object for current standings.
     */
    public Contest getContest() {
        return contest;
    }

    /**
     * @return An array of {@link Problem} objects of current contest.
     */
    public Problem[] getProblems() {
        return problems;
    }

    /**
     * @return An array of {@link RanklistRow} objects of current contest.
     */
    public RanklistRow[] getRows() {
        return rows;
    }
}
