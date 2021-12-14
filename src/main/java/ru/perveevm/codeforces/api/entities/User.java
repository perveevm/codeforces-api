package ru.perveevm.codeforces.api.entities;

/**
 * @author Perveev Mike (perveev_m@mail.ru)
 * <p>
 * Represents a Codeforces user.
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

    /**
     * @return Codeforces user handle.
     */
    public String getHandle() {
        return handle;
    }

    /**
     * @return User email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return User id for VK social network.
     */
    public String getVkId() {
        return vkId;
    }

    /**
     * @return User OpenId.
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @return Localized user first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return Localized user last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return Localized user country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @return Localized user city.
     */
    public String getCity() {
        return city;
    }

    /**
     * @return Localized user organization.
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @return User contribution.
     */
    public Integer getContribution() {
        return contribution;
    }

    /**
     * @return Localized user rank.
     */
    public String getRank() {
        return rank;
    }

    /**
     * @return User rating.
     */
    public Integer getRating() {
        return rating;
    }

    /**
     * @return Localized user maximal rank during his history.
     */
    public String getMaxRank() {
        return maxRank;
    }

    /**
     * @return User maximal rating during his history.
     */
    public Integer getMaxRating() {
        return maxRating;
    }

    /**
     * @return Time, when user was last seen online, in unix format.
     */
    public Integer getLastOnlineTimeSeconds() {
        return lastOnlineTimeSeconds;
    }

    /**
     * @return Time, when user was registered, in unix format.
     */
    public Integer getRegistrationTimeSeconds() {
        return registrationTimeSeconds;
    }

    /**
     * @return Amount of users who have this user in friends.
     */
    public Integer getFriendOfCount() {
        return friendOfCount;
    }

    /**
     * @return User's avatar URL.
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @return User's title photo URL.
     */
    public String getTitlePhoto() {
        return titlePhoto;
    }
}
