package ru.perveevm.codeforces.api.entities;

public class HackJudgeProtocol {
    private Boolean manual;
    private String protocol;
    private String verdict;

    public Boolean getManual() {
        return manual;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getVerdict() {
        return verdict;
    }
}
