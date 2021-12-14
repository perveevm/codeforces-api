package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ProblemResultType;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a submissions results of a party for a problem.
 */
public class ProblemResult {
    private Double points;
    private Integer penalty;
    private Integer rejectedAttemptCount;
    private ProblemResultType type;
    private Integer bestSubmissionTimeSeconds;

    /**
     * @return The number of score points.
     */
    public Double getPoints() {
        return points;
    }

    /**
     * @return Penalty (in ICPC meaning) of the party for this problem. Can be <code>null</code>.
     */
    public Integer getPenalty() {
        return penalty;
    }

    /**
     * @return Number of incorrect submissions.
     */
    public Integer getRejectedAttemptCount() {
        return rejectedAttemptCount;
    }

    /**
     * @return If type is {@link ProblemResultType#PRELIMINARY} then points can decrease (if, for example, solution will
     * fail during system test). Otherwise, party can only increase points for this problem by submitting better
     * solutions.
     */
    public ProblemResultType getType() {
        return type;
    }

    /**
     * @return Number of seconds after the start of the contest before the submission, that brought maximal amount of
     * points for this problem. Can be <code>null</code>.
     */
    public Integer getBestSubmissionTimeSeconds() {
        return bestSubmissionTimeSeconds;
    }
}
