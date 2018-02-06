package com.benjamin.benleethium.models;

import twitter4j.RateLimitStatus;

import java.util.ArrayList;

public class ResponseListFixture<T> extends ArrayList<T> implements twitter4j.ResponseList<T> {

    @Override
    public RateLimitStatus getRateLimitStatus() {
        return null;
    }

    @Override
    public int getAccessLevel() {
        return 0;
    }
}
