package com.benjamin.benleethium.models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TweetTest {

    @Test
    public void testSetMessage() {
        String message = "test";
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        assertEquals(message, tweet.getMessage());
    }
}
