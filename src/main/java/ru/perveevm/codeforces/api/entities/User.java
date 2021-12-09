package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 */
public class User {
    private String handle;
    private String email;
    private String vkId;
    private String openId;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String organization;
    private Integer contribution;
    private String rank;
    private Integer rating;
    private String maxRank;
    private Integer maxRating;
    private Integer lastOnlineTimeSeconds;
    private Integer registrationTimeSeconds;
    private Integer friendOfCount;
    private String avatar;
    private String titlePhoto;

    public String getHandle() {
        return handle;
    }

    public String getEmail() {
        return email;
    }

    public String getVkId() {
        return vkId;
    }

    public String getOpenId() {
        return openId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getOrganization() {
        return organization;
    }

    public Integer getContribution() {
        return contribution;
    }

    public String getRank() {
        return rank;
    }

    public Integer getRating() {
        return rating;
    }

    public String getMaxRank() {
        return maxRank;
    }

    public Integer getMaxRating() {
        return maxRating;
    }

    public Integer getLastOnlineTimeSeconds() {
        return lastOnlineTimeSeconds;
    }

    public Integer getRegistrationTimeSeconds() {
        return registrationTimeSeconds;
    }

    public Integer getFriendOfCount() {
        return friendOfCount;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTitlePhoto() {
        return titlePhoto;
    }
}
