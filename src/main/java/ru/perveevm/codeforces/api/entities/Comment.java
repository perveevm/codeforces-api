package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a comment.
 */
public class Comment {
    private Integer id;
    private Integer creationTimeSeconds;
    private String commentatorHandle;
    private String locale;
    private String text;
    private Integer parentCommentId;
    private Integer rating;

    /**
     * @return Comment ID. Can be found in the link.
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return Time, when comment was created, in unix format.
     */
    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    /**
     * @return Commentator handle.
     */
    public String getCommentatorHandle() {
        return commentatorHandle;
    }

    /**
     * @return Comment locale.
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @return Comment content.
     */
    public String getText() {
        return text;
    }

    /**
     * @return Comment's parent ID. Can be <code>null</code>.
     */
    public Integer getParentCommentId() {
        return parentCommentId;
    }

    /**
     * @return Comment rating.
     */
    public Integer getRating() {
        return rating;
    }
}
