package ru.perveevm.codeforces.api.entities;

/**
 * Represents a hack judge protocol.
 *
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class HackJudgeProtocol {
    private Boolean manual;
    private String protocol;
    private String verdict;

    /**
     * @return If manual is <code>true</code> then test for the hack was entered manually.
     */
    public Boolean getManual() {
        return manual;
    }

    /**
     * @return Human-readable description of judge protocol.
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * @return human-readable description of hack verdict.
     */
    public String getVerdict() {
        return verdict;
    }
}
