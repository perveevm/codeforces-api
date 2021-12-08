package ru.perveevm.codeforces.api.entities;

public class RatingChange {
    private Integer contestId;
    private String contestName;
    private String handle;
    private Integer rank;
    private Integer ratingUpdateTimeSeconds;
    private Integer oldRating;
    private Integer newRating;

    public Integer getContestId() {
        return contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public String getHandle() {
        return handle;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getRatingUpdateTimeSeconds() {
        return ratingUpdateTimeSeconds;
    }

    public Integer getOldRating() {
        return oldRating;
    }

    public Integer getNewRating() {
        return newRating;
    }
}
