package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * Represents a contest type.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
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
