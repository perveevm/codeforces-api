package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ContestPhase;
import ru.perveevm.codeforces.api.entities.enumerations.ContestType;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ContestType getType() {
        return type;
    }

    public ContestPhase getPhase() {
        return phase;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public String getKind() {
        return kind;
    }

    public String getIcpcRegion() {
        return icpcRegion;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getSeason() {
        return season;
    }
}
