package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ContestPhase;
import ru.perveevm.codeforces.api.entities.enumerations.ContestType;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a contest on Codeforces.
 */
public class Contest {
    private Integer id;
    private String name;
    private ContestType type;
    private ContestPhase phase;
    private Boolean frozen;
    private Integer durationSeconds;
    private Integer startTimeSeconds;
    private Integer relativeTimeSeconds;
    private String preparedBy;
    private String websiteUrl;
    private String description;
    private Integer difficulty;
    private String kind;
    private String icpcRegion;
    private String country;
    private String city;
    private String season;

    /**
     * @return Contest ID. Can be found in the link.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Localized contest name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Scoring system used for the contest.
     */
    public ContestType getType() {
        return type;
    }

    /**
     * @return Contest phase.
     */
    public ContestPhase getPhase() {
        return phase;
    }

    /**
     * @return If <code>true</code>, then the ranklist for the contest is frozen and shows only submissions,
     * created before freeze.
     */
    public Boolean getFrozen() {
        return frozen;
    }

    /**
     * @return Duration of the contest in seconds.
     */
    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    /**
     * @return Can be <code>null</code>. Contest start time in unix format.
     */
    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }

    /**
     * @return Can be <code>null</code>. Number of seconds, passed after the start of the contest. Can be negative.
     */
    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    /**
     * @return Can be <code>null</code>. Handle of the user, how created the contest.
     */
    public String getPreparedBy() {
        return preparedBy;
    }

    /**
     * @return Can be <code>null</code>. URL for contest-related website.
     */
    public String getWebsiteUrl() {
        return websiteUrl;
    }

    /**
     * @return Localized contest description. Can be <code>null</code>.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return Can be <code>null</code>. From 1 to 5. Larger number means more difficult problems.
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * @return Localized contest kind. Can be <code>null</code>. Human-readable type of the contest from the following
     * categories:
     * <ul>
     *     <li>Official ICPC Contest</li>
     *     <li>Official School Contest</li>
     *     <li>Opencup Contest</li>
     *     <li>School/University/City/Region Championship</li>
     *     <li>Training Camp Contest</li>
     *     <li>Official International Personal Contest</li>
     *     <li>Training Contest</li>
     * </ul>
     */
    public String getKind() {
        return kind;
    }

    /**
     * @return Localized ICPC region. Can be <code>null</code>. Name of the Region for official ICPC contests.
     */
    public String getIcpcRegion() {
        return icpcRegion;
    }

    /**
     * @return Localized country name. Can be <code>null</code>.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return Localized city name. Can be <code>null</code>.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return Contest season. Can be <code>null</code>.
     */
    public String getSeason() {
        return season;
    }
}
