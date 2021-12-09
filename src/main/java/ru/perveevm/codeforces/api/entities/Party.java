package ru.perveevm.codeforces.api.entities;

import ru.perveevm.codeforces.api.entities.enumerations.ParticipantType;

/**
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

    public Integer getContestId() {
        return contestId;
    }

    public Member[] getMembers() {
        return members;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public Boolean getGhost() {
        return ghost;
    }

    public Integer getRoom() {
        return room;
    }

    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }
}
