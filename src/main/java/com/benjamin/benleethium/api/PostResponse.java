package com.benjamin.benleethium.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostResponse {

    private String content;

    public PostResponse(String content) {
        this.content = content;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
