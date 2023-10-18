package ru.perveevm.codeforces.api.entities;

/**
 * Represents a Codeforces blog entry. May be in either short or full version.
 *
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

    /**
     * @return Blog ID. Can be found in the link.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Original locale of the blog entry.
     */
    public String getOriginalLocale() {
        return originalLocale;
    }

    /**
     * @return Time, when blog entry was created, in unix format.
     */
    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    /**
     * @return Author user handle.
     */
    public String getAuthorHandle() {
        return authorHandle;
    }

    /**
     * @return Localized title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return Localized content. <code>null</code> in the short version.
     */
    public String getContent() {
        return content;
    }

    /**
     * @return Blog locale.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @return Time, when blog entry has been updated, in unix format.
     */
    public Integer getModificationTimeSeconds() {
        return modificationTimeSeconds;
    }

    /**
     * @return If <code>true</code>, you can view any specific revision of the blog entry.
     */
    public Boolean isAllowViewHistory() {
        return allowViewHistory;
    }

    /**
     * @return An array of tags.
     */
    public String[] getTags() {
        return tags;
    }

    /**
     * @return Blog rating.
     */
    public Integer getRating() {
        return rating;
    }
}
