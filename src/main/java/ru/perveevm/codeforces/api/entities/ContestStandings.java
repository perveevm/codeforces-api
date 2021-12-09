package ru.perveevm.codeforces.api.entities;

public class ContestStandings {
    private Contest contest;
    private Problem[] problems;
    private RanklistRow[] rows;

    public Contest getContest() {
        return contest;
    }

    public Problem[] getProblems() {
        return problems;
    }

    public RanklistRow[] getRows() {
        return rows;
    }
}
