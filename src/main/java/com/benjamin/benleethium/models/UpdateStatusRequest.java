package com.benjamin.benleethium.models;

public class UpdateStatusRequest {
    private String message;
    private String inReplyToStatusId;


    public UpdateStatusRequest() {}

    public UpdateStatusRequest(String message) {
        this.message = message;
    }

    public UpdateStatusRequest(String inReplyToStatusId, String message) {
        this.inReplyToStatusId = inReplyToStatusId;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInReplyToStatusId(String inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public String getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }
}
