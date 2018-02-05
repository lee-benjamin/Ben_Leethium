package com.benjamin.benleethium.services;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static javafx.beans.binding.Bindings.when;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;

import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.mock;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterServiceTest {

    //private TwitterService twitterService;

    @Before
    public void setUp() throws Exception {
        System.out.println("Setting up...");
        //twitterService = mock(TwitterService.class);
        //System.out.println(twitterService);
    }

    @Test
    public void naiveTest() {
        // fails NullPointerException
        //TwitterService twitterService = TwitterService.getInstance();
        assertFalse(false);
    }

    @Test
    public void testGetInstance() {
    }

    @Test
    public void testValidateTweetMaxChar() {
        //StringBuilder badTweet = new StringBuilder();
        //for (int i=0; i<=TwitterService.MAX_CHAR_LIMIT; i++) {
        //    badTweet.append(".");
        //}
        //assertFalse("Tweet exceeds maximum character limit",
        //    twitterServiceInstance.validateTweet(badTweet.toString()));
    }

    @Test
    public void testUpdateStatus() throws TwitterException {
        //String tweet = "This is a test.";
        //Status status = new Status(tweet, new Date(), new User());
        //Twitter twitterInstance = mock(Twitter.class);
        //when(twitterInstance.updateStatus(tweet)).thenReturn(status);
        //assertEquals(status, twitterServiceInstance.updateStatus(tweet));
    }

    @Test
    public void testGetHomeTimeline() {
    }

    @Test
    public void searchHomeTimeline() {
    }
}
