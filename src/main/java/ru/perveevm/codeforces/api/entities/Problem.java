package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ProblemType;

/**
 * Represents a problem.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class Problem {
    private Integer contestId;
    private String problemsetName;
    private String index;
    private String name;
    private ProblemType type;
    private Double points;
    private Integer rating;
    private String[] tags;

    /**
     * @return Can be <code>null</code>. ID of the contest, containing the problem.
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * @return Can be <code>null</code>. Short name of the problemset the problem belongs to.
     */
    public String getProblemsetName() {
        return problemsetName;
    }

    /**
     * @return Usually, a letter or letter with digit(s) indicating the problem index in a contest.
     */
    public String getIndex() {
        return index;
    }

    /**
     * @return Localized problem name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Problem type.
     */
    public ProblemType getType() {
        return type;
    }

    /**
     * @return Can be <code>null</code>. Maximum amount of points for the problem.
     */
    public Double getPoints() {
        return points;
    }

    /**
     * @return Can be <code>null</code>. Problem rating (difficulty).
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @return An array of problem tags.
     */
    public String[] getTags() {
        return tags;
    }
}
