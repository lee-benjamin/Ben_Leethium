package com.benjamin.benleethium.models;

import java.util.Date;
import java.util.Objects;

public class Status {

    private String text;
    private Date createdAt;
    private String id;
    private User user;

    public Status() {}

    public Status(String text, Date createdAt, String id, User user) {
        this.text = text;
        this.createdAt = createdAt;
        this.id = id;
        this.user = user;
    }

    public Status(twitter4j.Status status) {
        this.text = status.getText();
        this.createdAt = status.getCreatedAt();
        this.id = String.valueOf(status.getId());
        this.setUser(status.getUser());
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(twitter4j.User user) {
        this.user = new User(user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(text, status.text) &&
                Objects.equals(createdAt, status.createdAt) &&
                Objects.equals(user, status.user);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text, createdAt, user);
    }
}
