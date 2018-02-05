package com.benjamin.benleethium.services;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

    private Twitter twitterInstance;
    private TwitterService twitterService;

    @Before
    public void setUp() throws Exception {
        twitterInstance = mock(Twitter.class);
        twitterService = TwitterService.getTestInstance(twitterInstance);
    }

    @Test
    public void testGetInstance() {
    }

    @Test
    public void testValidateTweetMaxChar() {
        StringBuilder badTweet = new StringBuilder();
        for (int i=0; i<=TwitterService.MAX_CHAR_LIMIT; i++) {
            badTweet.append(".");
        }
        assertFalse("Tweet exceeds maximum character limit.",
            twitterService.validateTweet(badTweet.toString()));
    }

    @Test
    public void testValidateTweetNull() {
        assertFalse("Testing null tweet.",
            twitterService.validateTweet(null));
    }

    @Test
    public void testValidateTweet() {
        String grandioseTweet = "North Korean Leader Kim Jong Un just stated that the "
            + "“Nuclear Button is on his desk at all times.” Will someone from his "
            + "depleted and food starved regime please inform him that I too have a "
            + "Nuclear Button, but it is a much bigger & more powerful one than his,"
            + " and my Button works!";
        assertTrue("Testing a legal tweet of 280 characters.",
            twitterService.validateTweet(grandioseTweet));
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
