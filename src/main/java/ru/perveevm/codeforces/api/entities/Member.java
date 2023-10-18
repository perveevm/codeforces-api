package ru.perveevm.codeforces.api.entities;

/**
 * Represents a member of a party.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class Member {
    private String handle;
    private String name;

    /**
     * @return Codeforces user handle.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * @return Can be <code>null</code>. User's name if available.
     */
    public String getName() {
        return name;
    }
}
