package com.benjamin.benleethium.models;

import java.util.Date;

import twitter4j.Status;

public class Message {

    private String text;
    private Date createdAt;
    private User user;

    public Message() {}

    public Message(String text, Date createdAt, User user) {
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Message(Status status) {
        this.text = status.getText();
        this.createdAt = status.getCreatedAt();
        this.setUser(status.getUser());
    }

    public String getText() {
        return this.text;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public User getUser() {
        return this.user;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUser(twitter4j.User user) {
        this.user = new User(user);
    }

    public String toString() {
        return "Message: [" + this.text + ", " + this.createdAt + ", " + this.user + "]";
    }
}
