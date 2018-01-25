package com.benjamin.benleethium.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class TwitterResponse {
    private long id;

    @Length(max = 3)
    private String content;

    public TwitterResponse() {
        // Jackson deserialization
    }

    public TwitterResponse(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
