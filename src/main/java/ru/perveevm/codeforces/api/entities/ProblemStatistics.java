package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class ProblemStatistics {
    private Integer contestId;
    private String index;
    private Integer solvedCount;

    public Integer getContestId() {
        return contestId;
    }

    public String getIndex() {
        return index;
    }

    public Integer getSolvedCount() {
        return solvedCount;
    }
}
