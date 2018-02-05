package com.benjamin.benleethium.models;

import twitter4j.*;
import twitter4j.Status;
import twitter4j.User;

import java.util.Date;

public class TestStatus implements twitter4j.Status {
    private Date createdAt;
    private long id;
    private String text;
    private String source;
    private boolean truncated;
    private long inReplyToUserId;
    private long inReplyToStatusId;
    private String inReplyToScreenName;
    private GeoLocation geoLocation;
    private Place place;
    private boolean Favorited;
    private boolean Retweeted;
    private int favoriteCount;
    private User user;
    private boolean retweet;
    private Status retweetedStatus;
    private long[] contributors;
    private int retweetCount;
    private boolean retweetedByMe;
    private long curretnUserRetweetId;
    private boolean possiblySensitive;
    private String lang;
    private Scopes scopes;
    private String[] witheldInCountries;
    private long quotedStatusId;
    private Status quotedStatus;
    private UserMentionEntity[] userMentionEntities;
    private URLEntity[] urlEntities;
    private HashtagEntity[] hashtagEntities;
    private MediaEntity[] mediaEntities;
    private ExtendedMediaEntity[] extendedMediaEntities;
    private SymbolEntity[] symbolEntities;
    private RateLimitStatus rateLimitStatus;
    private int accessLevel;

    @Override
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(boolean truncated) {
        this.truncated = truncated;
    }

    @Override
    public long getInReplyToUserId() {
        return inReplyToUserId;
    }

    public void setInReplyToUserId(long inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    @Override
    public long getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public void setInReplyToStatusId(long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    @Override
    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public void setInReplyToScreenName(String inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    @Override
    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    @Override
    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public boolean isFavorited() {
        return Favorited;
    }

    public void setFavorited(boolean favorited) {
        Favorited = favorited;
    }

    @Override
    public boolean isRetweeted() {
        return Retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        Retweeted = retweeted;
    }

    @Override
    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean isRetweet() {
        return retweet;
    }

    public void setRetweet(boolean retweet) {
        this.retweet = retweet;
    }

    @Override
    public Status getRetweetedStatus() {
        return retweetedStatus;
    }

    public void setRetweetedStatus(Status retweetedStatus) {
        this.retweetedStatus = retweetedStatus;
    }

    @Override
    public long[] getContributors() {
        return contributors;
    }

    public void setContributors(long[] contributors) {
        this.contributors = contributors;
    }

    @Override
    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    @Override
    public boolean isRetweetedByMe() {
        return retweetedByMe;
    }

    public void setRetweetedByMe(boolean retweetedByMe) {
        this.retweetedByMe = retweetedByMe;
    }

    public long getCurretnUserRetweetId() {
        return curretnUserRetweetId;
    }

    public void setCurretnUserRetweetId(long curretnUserRetweetId) {
        this.curretnUserRetweetId = curretnUserRetweetId;
    }

    @Override
    public boolean isPossiblySensitive() {
        return possiblySensitive;
    }

    public void setPossiblySensitive(boolean possiblySensitive) {
        this.possiblySensitive = possiblySensitive;
    }

    @Override
    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public Scopes getScopes() {
        return scopes;
    }

    public void setScopes(Scopes scopes) {
        this.scopes = scopes;
    }

    public String[] getWitheldInCountries() {
        return witheldInCountries;
    }

    public void setWitheldInCountries(String[] witheldInCountries) {
        this.witheldInCountries = witheldInCountries;
    }

    @Override
    public long getQuotedStatusId() {
        return quotedStatusId;
    }

    public void setQuotedStatusId(long quotedStatusId) {
        this.quotedStatusId = quotedStatusId;
    }

    @Override
    public Status getQuotedStatus() {
        return quotedStatus;
    }

    public void setQuotedStatus(Status quotedStatus) {
        this.quotedStatus = quotedStatus;
    }

    @Override
    public UserMentionEntity[] getUserMentionEntities() {
        return userMentionEntities;
    }

    public void setUserMentionEntities(UserMentionEntity[] userMentionEntities) {
        this.userMentionEntities = userMentionEntities;
    }

    public URLEntity[] getUrlEntities() {
        return urlEntities;
    }

    public void setUrlEntities(URLEntity[] urlEntities) {
        this.urlEntities = urlEntities;
    }

    @Override
    public HashtagEntity[] getHashtagEntities() {
        return hashtagEntities;
    }

    public void setHashtagEntities(HashtagEntity[] hashtagEntities) {
        this.hashtagEntities = hashtagEntities;
    }

    @Override
    public MediaEntity[] getMediaEntities() {
        return mediaEntities;
    }

    public void setMediaEntities(MediaEntity[] mediaEntities) {
        this.mediaEntities = mediaEntities;
    }

    @Override
    public ExtendedMediaEntity[] getExtendedMediaEntities() {
        return extendedMediaEntities;
    }

    public void setExtendedMediaEntities(ExtendedMediaEntity[] extendedMediaEntities) {
        this.extendedMediaEntities = extendedMediaEntities;
    }

    @Override
    public SymbolEntity[] getSymbolEntities() {
        return symbolEntities;
    }

    public void setSymbolEntities(SymbolEntity[] symbolEntities) {
        this.symbolEntities = symbolEntities;
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
}
