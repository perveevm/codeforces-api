package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.HackVerdict;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class Hack {
    private Integer id;
    private Integer creationTimeSeconds;
    private Party hacker;
    private Party defender;
    private HackVerdict verdict;
    private Problem problem;
    private String test;
    private HackJudgeProtocol judgeProtocol;

    public Integer getId() {
        return id;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public Party getHacker() {
        return hacker;
    }

    public Party getDefender() {
        return defender;
    }

    public HackVerdict getVerdict() {
        return verdict;
    }

    public Problem getProblem() {
        return problem;
    }

    public String getTest() {
        return test;
    }

    public HackJudgeProtocol getJudgeProtocol() {
        return judgeProtocol;
    }
}
