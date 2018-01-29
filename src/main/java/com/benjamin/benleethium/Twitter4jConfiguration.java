package com.benjamin.benleethium;

public class Twitter4jConfiguration {

    @NotEmpty
    @JsonProperty
    static final String CONSUMER_KEY;

    @NotEmpty
    @JsonProperty
    static final String CONSUMER_SECRET;

    @NotEmpty
    @JsonProperty
    static final String ACCESS_TOKEN;

    @NotEmpty
    @JsonProperty
    static final String ACCESS_TOKEN_SECRET;
    
}


