package com.benjamin.benleethium.models;

public class User {


    private String name;
    private String screenName;
    private String profileImageURL;

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

    public String getScreenName() {
        return this.screenName;
    }

    public String getProfileImageURL() {
        return this.profileImageURL;
    }
}
