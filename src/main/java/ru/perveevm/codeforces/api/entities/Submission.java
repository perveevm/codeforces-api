package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.SubmissionTestset;
import ru.perveevm.codeforces.api.entities.enumerations.SubmissionVerdict;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a submission.
 */
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

    /**
     * @return Submission ID. Can be found in the link.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Contest ID. Can be <code>null</code>.
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * @return Time, when submission was created, in unix-format.
     */
    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    /**
     * @return Number of seconds, passed after the start of the contest (or a virtual start for virtual parties),
     * before the submission.
     */
    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    /**
     * @return {@link Problem} object for the problem that this submission belongs to.
     */
    public Problem getProblem() {
        return problem;
    }

    /**
     * @return {@link Party} object for the party that this submission belongs to.
     */
    public Party getAuthor() {
        return author;
    }

    /**
     * @return Programming language name.
     */
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    /**
     * @return Submission status. Can be <code>null</code>.
     */
    public SubmissionVerdict getVerdict() {
        return verdict;
    }

    /**
     * @return Testset used for judging the submission.
     */
    public SubmissionTestset getTestset() {
        return testset;
    }

    /**
     * @return Number of passed tests.
     */
    public Integer getPassedTestCount() {
        return passedTestCount;
    }

    /**
     * @return Maximum time in milliseconds, consumed by solution for one test.
     */
    public Integer getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    /**
     * @return Maximum memory in bytes, consumed by solution for one test.
     */
    public Integer getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }

    /**
     * @return Can be <code>null</code>. Number of scored points for IOI-like contests.
     */
    public Double getPoints() {
        return points;
    }
}
