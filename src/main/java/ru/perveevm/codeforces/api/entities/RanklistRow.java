package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a ranklist row.
 */
public class RanklistRow {
    private Party party;
    private Integer rank;
    private Double points;
    private Integer penalty;
    private Integer successfulHackCount;
    private Integer unsuccessfulHackCount;
    private ProblemResult[] problemResults;
    private Integer lastSubmissionTimeSeconds;

    /**
     * @return Party that took a corresponding place in the contest.
     */
    public Party getParty() {
        return party;
    }

    /**
     * @return Party place in the contest.
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @return Total amount of points, scored by the party.
     */
    public Double getPoints() {
        return points;
    }

    /**
     * @return Total penalty (in ICPC meaning) of the party.
     */
    public Integer getPenalty() {
        return penalty;
    }

    /**
     * @return Number of successful hacks.
     */
    public Integer getSuccessfulHackCount() {
        return successfulHackCount;
    }

    /**
     * @return Number of unsuccessful hacks.
     */
    public Integer getUnsuccessfulHackCount() {
        return unsuccessfulHackCount;
    }

    /**
     * @return An array of {@link ProblemResult} objects. Party results for each problem. Order of the problems is
     * the same as in "problems" field of the returned object.
     */
    public ProblemResult[] getProblemResults() {
        return problemResults;
    }

    /**
     * @return For IOI contests only. Time in seconds from the start of the contest to the last submission that added
     * some points to the total score of the party. Can be <code>null</code>.
     */
    public Integer getLastSubmissionTimeSeconds() {
        return lastSubmissionTimeSeconds;
    }
}
