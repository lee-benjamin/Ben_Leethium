package com.benjamin.benleethium;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class Twitter4jConfiguration {

    @NotEmpty
    @JsonProperty
    static String CONSUMER_KEY;

    @NotEmpty
    @JsonProperty
    static String CONSUMER_SECRET;

    @NotEmpty
    @JsonProperty
    static String ACCESS_TOKEN;

    @NotEmpty
    @JsonProperty
    static String ACCESS_TOKEN_SECRET;
    
}


