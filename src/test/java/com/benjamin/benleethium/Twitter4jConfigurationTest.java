package com.benjamin.benleethium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Twitter4jConfigurationTest {

    String key = "KEY";
    private Twitter4jConfiguration conf;

    @Before
    public void setUp() {
        conf = new Twitter4jConfiguration();
    }

    @Test
    public void testGetConsumerKey() {
        conf.setConsumerKey(key);
        assertEquals(key, conf.getConsumerKey());
    }

    @Test
    public void getConsumerSecret() {
        conf.setConsumerSecret(key);
        assertEquals(key, conf.getConsumerSecret());
    }

    @Test
    public void getAccessToken() {
        conf.setAccessToken(key);
        assertEquals(key, conf.getAccessToken());
    }

    @Test
    public void getAccessTokenSecret() {
        conf.setAccessTokenSecret(key);
        assertEquals(key, conf.getAccessTokenSecret());
    }
}
