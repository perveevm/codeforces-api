package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class RecentAction {
    private Integer timeSeconds;
    private BlogEntry blogEntry;
    private Comment comment;

    public Integer getTimeSeconds() {
        return timeSeconds;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public Comment getComment() {
        return comment;
    }
}
