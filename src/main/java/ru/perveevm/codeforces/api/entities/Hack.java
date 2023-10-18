package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.HackVerdict;

/**
 * Represents a hack, made during Codeforces Round.
 *
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

    /**
     * @return Hack ID. Can be found in the link.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Hack creation time in unix format.
     */
    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    /**
     * @return {@link Party} object for the party that this hack belongs to.
     */
    public Party getHacker() {
        return hacker;
    }

    /**
     * @return {@link Party} object for the party that this hack was assigned to.
     */
    public Party getDefender() {
        return defender;
    }

    /**
     * @return Hack verdict. Can be <code>null</code>.
     */
    public HackVerdict getVerdict() {
        return verdict;
    }

    /**
     * @return Hacked problem.
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * @return Test data. Can be <code>null</code>.
     */
    public String getTest() {
        return test;
    }

    /**
     * @return Localized hack protocol. Can be <code>null</code>.
     */
    public HackJudgeProtocol getJudgeProtocol() {
        return judgeProtocol;
    }
}
