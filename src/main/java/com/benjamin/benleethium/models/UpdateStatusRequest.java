package com.benjamin.benleethium.models;

public class UpdateStatusRequest {
    private String message;
    private long id;


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

    public void setInReplyToStatusId(long id) {
        this.id = id;
    }

    public long getInReplyToStatusId() {
        return this.id;
    }
}
