package com.benjamin.benleethium;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Twitter4jConfiguration {

    @NotEmpty
    private String consumerKey;

    @NotEmpty
    @JsonProperty
    private String consumerSecret;

    @NotEmpty
    @JsonProperty
    private String accessToken;

    @NotEmpty
    @JsonProperty
    private String accessTokenSecret;

    @JsonProperty
    public String getConsumerKey() {
        return consumerKey;
    }

    public void setConsumerKey(String consumerKey) {
        this.consumerKey = consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public void setConsumerSecret(String consumerSecret) {
        this.consumerSecret = consumerSecret;
    }
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }
}
