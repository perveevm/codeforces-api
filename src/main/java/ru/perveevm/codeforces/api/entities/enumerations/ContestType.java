package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a contest type.
 */
public enum ContestType {
    /**
     * CodeForces round.
     */
    CF,
    /**
     * IOI-style contest with partial scores.
     */
    IOI,
    /**
     * ICPC-style contest with penalties.
     */
    ICPC
}
