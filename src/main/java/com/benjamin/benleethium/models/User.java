package com.benjamin.benleethium.models;

import java.util.Objects;

public class User {

    private String name;
    private String screenName;
    private String profileImageURL;

    public User() {}

    public User(String name, String screenName, String profileImageURL) {
        this.name = name;
        this.screenName = screenName;
        this.profileImageURL = profileImageURL;
    }

    public User(twitter4j.User user) {
        this.name = user.getName();
        this.screenName = user.getScreenName();
        this.profileImageURL = user.getProfileImageURL();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScreenName() {
        return this.screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageURL() {
        return this.profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(screenName, user.screenName) &&
                Objects.equals(profileImageURL, user.profileImageURL);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, screenName, profileImageURL);
    }
}
