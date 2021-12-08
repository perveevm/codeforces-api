package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.SubmissionTestset;
import ru.perveevm.codeforces.api.entities.enumerations.SubmissionVerdict;

public class Submission {
    private Integer id;
    private Integer contestId;
    private Integer creationTimeSeconds;
    private Integer relativeTimeSeconds;
    private Problem problem;
    private Party author;
    private String programmingLanguage;
    private SubmissionVerdict verdict;
    private SubmissionTestset testset;
    private Integer passedTestCount;
    private Integer timeConsumedMillis;
    private Integer memoryConsumedBytes;
    private Double points;

    public Integer getId() {
        return id;
    }

    public Integer getContestId() {
        return contestId;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public Problem getProblem() {
        return problem;
    }

    public Party getAuthor() {
        return author;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public SubmissionVerdict getVerdict() {
        return verdict;
    }

    public SubmissionTestset getTestset() {
        return testset;
    }

    public Integer getPassedTestCount() {
        return passedTestCount;
    }

    public Integer getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public Integer getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }

    public Double getPoints() {
        return points;
    }
}
