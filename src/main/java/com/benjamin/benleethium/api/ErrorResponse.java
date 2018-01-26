package com.benjamin.benleethium.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponse {

    private String message;

    public ErrorResponse() {
        // Jackson deserialization
    }

    public ErrorResponse(String message) {
        this.message = message;
    }

    @JsonProperty
    public String getMessage() {
        return message;
    }
}
