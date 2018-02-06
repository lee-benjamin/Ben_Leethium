package com.benjamin.benleethium.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;
import com.benjamin.benleethium.models.TestStatus;
import com.benjamin.benleethium.models.TestUser;

import java.util.Date;

import org.mockito.Mockito;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class TwitterServiceTest {

    private Twitter twitterInstance;
    private TwitterService twitterService;

    @Before
    public void setUp() {
        twitterInstance = Mockito.mock(Twitter.class);
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
        String tweet = "This is a test.";
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        Date date = new Date();

        // Construct the twitter4j.Status to be mocked
        TestStatus testStatus = new TestStatus();
        TestUser testUser = new TestUser();

        testUser.setName(name);
        testUser.setScreenName(screenName);
        testUser.setProfileImageURL(profileImageURL);
        testStatus.setText(tweet);
        testStatus.setCreatedAt(date);
        testStatus.setUser(testUser);

        // Construct the expected benleethium Status to be returned by Twitter Service
        User parsedUser = new User(name, screenName, profileImageURL);
        Status expectedResult = new Status(tweet, date, parsedUser);

        // Mock dependency's logic
        Mockito.when(twitterInstance.updateStatus(tweet)).thenReturn(testStatus);

        // Verify values
        twitterService.updateStatus(tweet);
        assertEquals(expectedResult, twitterService.updateStatus(tweet));
    }

    @Test
    public void testGetHomeTimeline() {
    }

    @Test
    public void searchHomeTimeline() {
    }
}
