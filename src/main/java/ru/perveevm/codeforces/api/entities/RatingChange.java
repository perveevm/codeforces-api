package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a participation of user in rated contest.
 */
public class RatingChange {
    private Integer contestId;
    private String contestName;
    private String handle;
    private Integer rank;
    private Integer ratingUpdateTimeSeconds;
    private Integer oldRating;
    private Integer newRating;

    /**
     * @return Contest ID. Can be found in the link.
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * @return Localized contest name.
     */
    public String getContestName() {
        return contestName;
    }

    /**
     * @return Codeforces user handle.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * @return Place of the user in the contest. This field contains user rank on the moment of rating update.
     * If afterwards rank changes (e.g. someone gets disqualified), this field will not be updated and will contain
     * old rank.
     */
    public Integer getRank() {
        return rank;
    }

    /**
     * @return Time, when rating for the contest was update, in unix-format.
     */
    public Integer getRatingUpdateTimeSeconds() {
        return ratingUpdateTimeSeconds;
    }

    /**
     * @return User rating before the contest.
     */
    public Integer getOldRating() {
        return oldRating;
    }

    /**
     * @return User rating after the contest.
     */
    public Integer getNewRating() {
        return newRating;
    }
}
