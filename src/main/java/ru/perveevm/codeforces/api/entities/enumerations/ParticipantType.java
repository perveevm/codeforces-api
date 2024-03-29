package ru.perveevm.codeforces.api.entities.enumerations;

/**
 * Represents a participation type.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public enum ParticipantType {
    /**
     * The participant is registered to a competition officially.
     */
    CONTESTANT,
    /**
     * The participant is registered to the upsolving.
     */
    PRACTICE,
    /**
     * The participant is registered as a virtual participant.
     */
    VIRTUAL,
    /**
     * The participant is a manager of a competition.
     */
    MANAGER,
    /**
     * The participant is out of the competition.
     */
    OUT_OF_COMPETITION
}
