package ru.perveevm.codeforces.api.entities;

public class Comment {
    private Integer id;
    private Integer creationTimeSeconds;
    private String commentatorHandle;
    private String locale;
    private String text;
    private Integer parentCommentId;
    private Integer rating;

    public Integer getId() {
        return id;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public String getCommentatorHandle() {
        return commentatorHandle;
    }

    public String getLocale() {
        return locale;
    }

    public String getText() {
        return text;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public Integer getRating() {
        return rating;
    }
}
