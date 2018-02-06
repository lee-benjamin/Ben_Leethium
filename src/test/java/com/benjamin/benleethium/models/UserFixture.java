package com.benjamin.benleethium.models;

import twitter4j.RateLimitStatus;
import twitter4j.Status;
import twitter4j.URLEntity;
import twitter4j.User;

import java.util.Date;

public class UserFixture implements User {

    private long id;
    private String name;
    private String screenName;
    private String location;
    private String description;
    private boolean contributorsEnabled;
    private String profileImageURL;
    private String biggerProfileImageURL;
    private String miniProfileImageURL;
    private String originalProfileImageURL;
    private String profileImageURLHttps;
    private String biggerProfileImageURLHttps;
    private String miniProfileImageURLHttps;
    private String originalProfileImageURLHttps;
    private boolean defaultProfileImage;
    private String url;
    private boolean isProtected;
    private int followersCount;
    private Status status;
    private String profileBackgroundColor;
    private String profileTextColor;
    private String profileLinkColor;
    private String profileSidebarFillColor;
    private String profileSidebarBorderColor;
    private boolean isProfileUseBackgroundImage;
    private boolean isDefaultProfile;
    private boolean isShowAllInlineMedia;
    private int friendsCount;
    private Date createdAt;
    private int favouritesCount;
    private int utcOffset;
    private String timeZone;
    private String profileBackgroundImageURL;
    private String profileBackgroundImageUrlHttps;
    private String profileBannerURL;
    private String profileBannerMobileRetinaURL;
    private String profileBannerIPadURL;
    private String profileBannerIPadRetinaURL;
    private String profileBannerMobileURL;
    private String profileBannerRetinaURL;
    private boolean isProfileBackgroundTiled;
    private String lang;
    private int statusesCount;
    private boolean isGeoEnabled;
    private boolean isVerified;
    private boolean isTranslator;
    private int listedCount;
    private boolean isFollowRequestSent;
    private URLEntity[] descriptionURLEntities;
    private URLEntity urlEntity;
    private String[] withheldInCountries;
    private RateLimitStatus rateLimitStatus;
    private int accessLevel;
    private String email;

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @Override
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isContributorsEnabled() {
        return contributorsEnabled;
    }

    public void setContributorsEnabled(boolean contributorsEnabled) {
        this.contributorsEnabled = contributorsEnabled;
    }

    @Override
    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
    }

    @Override
    public String getBiggerProfileImageURL() {
        return biggerProfileImageURL;
    }

    public void setBiggerProfileImageURL(String biggerProfileImageURL) {
        this.biggerProfileImageURL = biggerProfileImageURL;
    }

    @Override
    public String getMiniProfileImageURL() {
        return miniProfileImageURL;
    }

    public void setMiniProfileImageURL(String miniProfileImageURL) {
        this.miniProfileImageURL = miniProfileImageURL;
    }

    @Override
    public String getOriginalProfileImageURL() {
        return originalProfileImageURL;
    }

    public void setOriginalProfileImageURL(String originalProfileImageURL) {
        this.originalProfileImageURL = originalProfileImageURL;
    }

    @Override
    public String getProfileImageURLHttps() {
        return profileImageURLHttps;
    }

    public void setProfileImageURLHttps(String profileImageURLHttps) {
        this.profileImageURLHttps = profileImageURLHttps;
    }

    @Override
    public String getBiggerProfileImageURLHttps() {
        return biggerProfileImageURLHttps;
    }

    public void setBiggerProfileImageURLHttps(String biggerProfileImageURLHttps) {
        this.biggerProfileImageURLHttps = biggerProfileImageURLHttps;
    }

    @Override
    public String getMiniProfileImageURLHttps() {
        return miniProfileImageURLHttps;
    }

    public void setMiniProfileImageURLHttps(String miniProfileImageURLHttps) {
        this.miniProfileImageURLHttps = miniProfileImageURLHttps;
    }

    @Override
    public String getOriginalProfileImageURLHttps() {
        return originalProfileImageURLHttps;
    }

    public void setOriginalProfileImageURLHttps(String originalProfileImageURLHttps) {
        this.originalProfileImageURLHttps = originalProfileImageURLHttps;
    }

    @Override
    public boolean isDefaultProfileImage() {
        return defaultProfileImage;
    }

    public void setDefaultProfileImage(boolean defaultProfileImage) {
        this.defaultProfileImage = defaultProfileImage;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Override
    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    @Override
    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String getProfileBackgroundColor() {
        return profileBackgroundColor;
    }

    public void setProfileBackgroundColor(String profileBackgroundColor) {
        this.profileBackgroundColor = profileBackgroundColor;
    }

    @Override
    public String getProfileTextColor() {
        return profileTextColor;
    }

    public void setProfileTextColor(String profileTextColor) {
        this.profileTextColor = profileTextColor;
    }

    @Override
    public String getProfileLinkColor() {
        return profileLinkColor;
    }

    public void setProfileLinkColor(String profileLinkColor) {
        this.profileLinkColor = profileLinkColor;
    }

    @Override
    public String getProfileSidebarFillColor() {
        return profileSidebarFillColor;
    }

    public void setProfileSidebarFillColor(String profileSidebarFillColor) {
        this.profileSidebarFillColor = profileSidebarFillColor;
    }

    @Override
    public String getProfileSidebarBorderColor() {
        return profileSidebarBorderColor;
    }

    public void setProfileSidebarBorderColor(String profileSidebarBorderColor) {
        this.profileSidebarBorderColor = profileSidebarBorderColor;
    }

    @Override
    public boolean isProfileUseBackgroundImage() {
        return isProfileUseBackgroundImage;
    }

    public void setProfileUseBackgroundImage(boolean profileUseBackgroundImage) {
        isProfileUseBackgroundImage = profileUseBackgroundImage;
    }

    @Override
    public boolean isDefaultProfile() {
        return isDefaultProfile;
    }

    public void setDefaultProfile(boolean defaultProfile) {
        isDefaultProfile = defaultProfile;
    }

    @Override
    public boolean isShowAllInlineMedia() {
        return isShowAllInlineMedia;
    }

    public void setShowAllInlineMedia(boolean showAllInlineMedia) {
        isShowAllInlineMedia = showAllInlineMedia;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public int getFavouritesCount() {
        return favouritesCount;
    }

    public void setFavouritesCount(int favouritesCount) {
        this.favouritesCount = favouritesCount;
    }

    @Override
    public int getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(int utcOffset) {
        this.utcOffset = utcOffset;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String getProfileBackgroundImageURL() {
        return profileBackgroundImageURL;
    }

    public void setProfileBackgroundImageURL(String profileBackgroundImageURL) {
        this.profileBackgroundImageURL = profileBackgroundImageURL;
    }

    @Override
    public String getProfileBackgroundImageUrlHttps() {
        return profileBackgroundImageUrlHttps;
    }

    public void setProfileBackgroundImageUrlHttps(String profileBackgroundImageUrlHttps) {
        this.profileBackgroundImageUrlHttps = profileBackgroundImageUrlHttps;
    }

    @Override
    public String getProfileBannerURL() {
        return profileBannerURL;
    }

    public void setProfileBannerURL(String profileBannerURL) {
        this.profileBannerURL = profileBannerURL;
    }

    @Override
    public String getProfileBannerMobileRetinaURL() {
        return profileBannerMobileRetinaURL;
    }

    public void setProfileBannerMobileRetinaURL(String profileBannerMobileRetinaURL) {
        this.profileBannerMobileRetinaURL = profileBannerMobileRetinaURL;
    }

    @Override
    public String getProfileBannerIPadURL() {
        return profileBannerIPadURL;
    }

    public void setProfileBannerIPadURL(String profileBannerIPadURL) {
        this.profileBannerIPadURL = profileBannerIPadURL;
    }

    @Override
    public String getProfileBannerIPadRetinaURL() {
        return profileBannerIPadRetinaURL;
    }

    public void setProfileBannerIPadRetinaURL(String profileBannerIPadRetinaURL) {
        this.profileBannerIPadRetinaURL = profileBannerIPadRetinaURL;
    }

    @Override
    public String getProfileBannerMobileURL() {
        return profileBannerMobileURL;
    }

    public void setProfileBannerMobileURL(String profileBannerMobileURL) {
        this.profileBannerMobileURL = profileBannerMobileURL;
    }

    @Override
    public String getProfileBannerRetinaURL() {
        return profileBannerRetinaURL;
    }

    public void setProfileBannerRetinaURL(String profileBannerRetinaURL) {
        this.profileBannerRetinaURL = profileBannerRetinaURL;
    }

    @Override
    public boolean isProfileBackgroundTiled() {
        return isProfileBackgroundTiled;
    }

    public void setProfileBackgroundTiled(boolean profileBackgroundTiled) {
        isProfileBackgroundTiled = profileBackgroundTiled;
    }

    @Override
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public int getStatusesCount() {
        return statusesCount;
    }

    public void setStatusesCount(int statusesCount) {
        this.statusesCount = statusesCount;
    }

    @Override
    public boolean isGeoEnabled() {
        return isGeoEnabled;
    }

    public void setGeoEnabled(boolean geoEnabled) {
        isGeoEnabled = geoEnabled;
    }

    @Override
    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    @Override
    public boolean isTranslator() {
        return isTranslator;
    }

    public void setTranslator(boolean translator) {
        isTranslator = translator;
    }

    @Override
    public int getListedCount() {
        return listedCount;
    }

    public void setListedCount(int listedCount) {
        this.listedCount = listedCount;
    }

    @Override
    public boolean isFollowRequestSent() {
        return isFollowRequestSent;
    }

    public void setFollowRequestSent(boolean followRequestSent) {
        isFollowRequestSent = followRequestSent;
    }

    @Override
    public URLEntity[] getDescriptionURLEntities() {
        return descriptionURLEntities;
    }

    public void setDescriptionURLEntities(URLEntity[] descriptionURLEntities) {
        this.descriptionURLEntities = descriptionURLEntities;
    }

    public URLEntity getURLEntity() {
        return urlEntity;
    }

    public void setURLEntity(URLEntity urlEntity) {
        this.urlEntity = urlEntity;
    }

    @Override
    public String[] getWithheldInCountries() {
        return withheldInCountries;
    }

    public void setWithheldInCountries(String[] withheldInCountries) {
        this.withheldInCountries = withheldInCountries;
    }

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return rateLimitStatus;
    }

    public void setRateLimitStatus(RateLimitStatus rateLimitStatus) {
        this.rateLimitStatus = rateLimitStatus;
    }

    @Override
    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public int compareTo(User o) {
        return 0;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
