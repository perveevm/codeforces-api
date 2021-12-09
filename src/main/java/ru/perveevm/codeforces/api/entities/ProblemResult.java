package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ProblemResultType;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class ProblemResult {
    private Double points;
    private Integer penalty;
    private Integer rejectedAttemptCount;
    private ProblemResultType type;
    private Integer bestSubmissionTimeSeconds;

    public Double getPoints() {
        return points;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public Integer getRejectedAttemptCount() {
        return rejectedAttemptCount;
    }

    public ProblemResultType getType() {
        return type;
    }

    public Integer getBestSubmissionTimeSeconds() {
        return bestSubmissionTimeSeconds;
    }
}
