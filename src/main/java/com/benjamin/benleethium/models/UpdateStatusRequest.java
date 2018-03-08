package com.benjamin.benleethium.models;

public class UpdateStatusRequest {
    public String message;

    public UpdateStatusRequest() {}

    public UpdateStatusRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
