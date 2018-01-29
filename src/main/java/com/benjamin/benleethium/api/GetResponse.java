package com.benjamin.benleethium.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GetResponse {

    private List<String> content;

    public GetResponse(List<String> content) {
        this.content = content;
    }

    @JsonProperty
    public List<String> getContent() {
        return content;
    }
}
