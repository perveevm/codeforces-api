package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class BlogEntry {
    private Integer id;
    private String originalLocale;
    private Integer creationTimeSeconds;
    private String authorHandle;
    private String title;
    private String content;
    private String locale;
    private Integer modificationTimeSeconds;
    private Boolean allowViewHistory;
    private String[] tags;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public String getOriginalLocale() {
        return originalLocale;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public String getAuthorHandle() {
        return authorHandle;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLocale() {
        return locale;
    }

    public Integer getModificationTimeSeconds() {
        return modificationTimeSeconds;
    }

    public Boolean isAllowViewHistory() {
        return allowViewHistory;
    }

    public String[] getTags() {
        return tags;
    }

    public Integer getRating() {
        return rating;
    }
}
