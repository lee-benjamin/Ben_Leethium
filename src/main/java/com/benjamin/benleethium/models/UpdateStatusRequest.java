package com.benjamin.benleethium.models;

public class UpdateStatusRequest {
    private String message;
    private long inReplyToStatusId;


    public UpdateStatusRequest() {}

    public UpdateStatusRequest(String message) {
        this.message = message;
    }

    public UpdateStatusRequest(long inReplyToStatusId, String message) {
        this.inReplyToStatusId = inReplyToStatusId;
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setInReplyToStatusId(long inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    public long getInReplyToStatusId() {
        return this.inReplyToStatusId;
    }
}
