package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ParticipantType;

/**
 * Represents a party, participating in a contest.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class Party {
    private Integer contestId;
    private Member[] members;
    private ParticipantType participantType;
    private Integer teamId;
    private String teamName;
    private Boolean ghost;
    private Integer room;
    private Integer startTimeSeconds;

    /**
     * @return Contest ID. Can be found in the link.
     */
    public Integer getContestId() {
        return contestId;
    }

    /**
     * @return An array of {@link Member} objects. Members of the party.
     */
    public Member[] getMembers() {
        return members;
    }

    /**
     * @return Participation type.
     */
    public ParticipantType getParticipantType() {
        return participantType;
    }

    /**
     * @return Can be <code>null</code>. If party is a team, then it is a unique team id.
     * Otherwise, this field is <code>null</code>.
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * @return Localized. Can be <code>null</code>. If party is a team or ghost, then it is a localized name
     * of the team. Otherwise, it is <code>null</code>.
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @return If <code>true</code> then this party is a ghost. It participated in the contest, but not on Codeforces.
     * For example, Andrew Stankevich Contests in Gym has ghosts of the participants from Petrozavodsk Training Camp.
     */
    public Boolean getGhost() {
        return ghost;
    }

    /**
     * @return Can be <code>null</code>. Room of the party. If <code>null</code>, then the party has no room.
     */
    public Integer getRoom() {
        return room;
    }

    /**
     * @return Can be <code>null</code>. Time, when this party started a contest.
     */
    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }
}
