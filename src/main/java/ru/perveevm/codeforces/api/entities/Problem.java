package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ProblemType;

public class Problem {
    private Integer contestId;
    private String problemsetName;
    private String index;
    private String name;
    private ProblemType type;
    private Double points;
    private Integer rating;
    private String[] tags;

    public Integer getContestId() {
        return contestId;
    }

    public String getProblemsetName() {
        return problemsetName;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public ProblemType getType() {
        return type;
    }

    public Double getPoints() {
        return points;
    }

    public Integer getRating() {
        return rating;
    }

    public String[] getTags() {
        return tags;
    }
}
