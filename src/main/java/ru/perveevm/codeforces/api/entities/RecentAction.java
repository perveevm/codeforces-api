package ru.perveevm.codeforces.api.entities;

/**
 * Represents a recent action.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class RecentAction {
    private Integer timeSeconds;
    private BlogEntry blogEntry;
    private Comment comment;

    /**
     * @return Action time, in unix format.
     */
    public Integer getTimeSeconds() {
        return timeSeconds;
    }

    /**
     * @return {@link BlogEntry} object in short form. Can be <code>null</code>.
     */
    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    /**
     * @return {@link Comment} object. Can be <code>null</code>.
     */
    public Comment getComment() {
        return comment;
    }
}
