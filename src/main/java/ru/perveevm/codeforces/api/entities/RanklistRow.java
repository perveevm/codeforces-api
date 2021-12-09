package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
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

    public Party getParty() {
        return party;
    }

    public Integer getRank() {
        return rank;
    }

    public Double getPoints() {
        return points;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public Integer getSuccessfulHackCount() {
        return successfulHackCount;
    }

    public Integer getUnsuccessfulHackCount() {
        return unsuccessfulHackCount;
    }

    public ProblemResult[] getProblemResults() {
        return problemResults;
    }

    public Integer getLastSubmissionTimeSeconds() {
        return lastSubmissionTimeSeconds;
    }
}
