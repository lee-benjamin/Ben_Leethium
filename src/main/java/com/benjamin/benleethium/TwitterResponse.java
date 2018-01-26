package com.benjamin.benleethium.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class TwitterResponse {
    private long id;

    @Length(max = 3)
    private List<String> content;

    public TwitterResponse() {
        // Jackson deserialization
    }

    public TwitterResponse(long id, List<String> content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public List<String> getContent() {
        return content;
    }
}
