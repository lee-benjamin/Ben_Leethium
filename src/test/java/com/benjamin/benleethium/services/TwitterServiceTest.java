package com.benjamin.benleethium.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;
import com.benjamin.benleethium.models.TestStatus;
import com.benjamin.benleethium.models.TestUser;
import com.benjamin.benleethium.models.TestResponseList;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.ResponseList;

public class TwitterServiceTest {

    private Twitter twitterInstance;
    private TwitterService twitterService;

    @Before
    public void setUp() {
        twitterInstance = Mockito.mock(Twitter.class);
        twitterService = TwitterService.getTestInstance(twitterInstance);
    }

    @Test
    public void testGetTestInstance() {
        assertNotNull(twitterService);
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

        // Construct the expected Status to be returned by TwitterService
        User parsedUser = new User(name, screenName, profileImageURL);
        Status expectedResult = new Status(tweet, date, parsedUser);

        // Mock dependency's logic
        Mockito.when(twitterInstance.updateStatus(tweet)).thenReturn(testStatus);

        // Verify values
        assertEquals(expectedResult, twitterService.updateStatus(tweet));
    }

    @Test
    public void testGetHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        Date date = new Date();

        // twitterInstance.getHomeTimeline() returns a ResponseList
        ResponseList<twitter4j.Status> testStatuses = new TestResponseList<>();
        // TwitterService.getHomeTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        TestStatus testStatus;
        TestUser testUser;
        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        // Construct the list of twitter4j.Statuses to be mocked
        for (int i=0; i<tweets.length;i++) {
            testStatus = new TestStatus();
            testUser = new TestUser();

            // Construct twitter4j's response
            testUser.setName(name);
            testUser.setScreenName(screenName);
            testUser.setProfileImageURL(profileImageURL);
            testStatus.setText(tweets[i]);
            testStatus.setCreatedAt(date);
            testStatus.setUser(testUser);

            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweets[i], date, parsedUser);

            // save to list
            testStatuses.add(testStatus);
            expectedResults.add(parsedStatus);
        }
        // Mock dependency's logic
        Mockito.when(twitterInstance.getHomeTimeline()).thenReturn(testStatuses);

        // Verify values
        for (int i=0; i<tweets.length; i++) {
            assertEquals(expectedResults.get(i), twitterService.getHomeTimeline().get(i));
        }
    }

    @Test
    public void searchHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String query = "tweet";
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        Date date = new Date();

        // twitterInstance.getHomeTimeline() returns a ResponseList
        ResponseList<twitter4j.Status> testStatuses = new TestResponseList<>();

        TestStatus testStatus;
        TestUser testUser;
        int count = 0; // counts the occurrences of 'query' in tweets[]

        // Construct the list of twitter4j.Statuses to be mocked
        for (int i=0; i<tweets.length;i++) {
            if (tweets[i].contains(query)) {
                count++;
            }

            testStatus = new TestStatus();
            testUser = new TestUser();

            // Construct twitter4j's response
            testUser.setName(name);
            testUser.setScreenName(screenName);
            testUser.setProfileImageURL(profileImageURL);
            testStatus.setText(tweets[i]);
            testStatus.setCreatedAt(date);
            testStatus.setUser(testUser);

            // save to list
            testStatuses.add(testStatus);
        }
        // Mock dependency's logic
        Mockito.when(twitterInstance.getHomeTimeline()).thenReturn(testStatuses);
        assertEquals(count, twitterService.searchHomeTimeline(query).size());
    }
}
