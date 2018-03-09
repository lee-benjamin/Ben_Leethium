package com.benjamin.benleethium.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.BenLeethiumConfiguration;
import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;
import com.benjamin.benleethium.models.StatusFixture;
import com.benjamin.benleethium.models.UserFixture;
import com.benjamin.benleethium.models.ResponseListFixture;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.ResponseList;

public class TwitterServiceTest {

    private Twitter twitterInstance;
    private TwitterService twitterService;
    private BenLeethiumConfiguration conf;

    @Before
    public void setUp() {
        twitterInstance = mock(Twitter.class);
        twitterService = new TwitterService(twitterInstance);
    }

    @Test
    public void testValidateTweetMaxChar() {
        String badTweet = new String(new char[TwitterService.MAX_CHAR_LIMIT + 1]);
        assertFalse("Tweet exceeds maximum character limit.",
            twitterService.validateTweet(badTweet.toString()));
    }

    @Test
    public void testValidateTweetEmptyId() {
        StatusUpdate status = new StatusUpdate("");
        assertFalse("Testing null reply ID.",
            twitterService.validateTweet(status));
    }

    @Test
    public void testValidateTweetNull() {
        String message = null;
        assertFalse("Testing null tweet.",
            twitterService.validateTweet(message));
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
        String id = "0";
        Date date = new Date();

        // Construct the twitter4j.Status to be mocked
        StatusFixture statusFixture = new StatusFixture();
        UserFixture userFixture = new UserFixture();

        userFixture.setName(name);
        userFixture.setScreenName(screenName);
        userFixture.setProfileImageURL(profileImageURL);
        statusFixture.setText(tweet);
        statusFixture.setCreatedAt(date);
        statusFixture.setUser(userFixture);

        // Construct the expected Status to be returned by TwitterService
        User parsedUser = new User(name, screenName, profileImageURL);
        Status expectedResult = new Status(tweet, date, id, parsedUser);

        // Mock dependency's logic
        Mockito.when(twitterInstance.updateStatus(tweet)).thenReturn(statusFixture);

        // Verify values
        assertEquals(expectedResult, twitterService.updateStatus(tweet));
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateStatusMalformed() throws TwitterException {
        String badTweet = new String(new char[TwitterService.MAX_CHAR_LIMIT + 1]);
        twitterService.updateStatus(badTweet);
    }

    @Test
    public void testGetUserTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        // twitterInstance.getUserTimeline() returns a ResponseList
        ResponseList<twitter4j.Status> testStatuses = new ResponseListFixture<>();
        // TwitterService.getUserTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        StatusFixture statusFixture;
        UserFixture userFixture;
        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        // Construct the list of twitter4j.Statuses to be mocked
        for (String tweet : tweets) {
            statusFixture = new StatusFixture();
            userFixture = new UserFixture();

            // Construct twitter4j's response
            userFixture.setName(name);
            userFixture.setScreenName(screenName);
            userFixture.setProfileImageURL(profileImageURL);
            statusFixture.setText(tweet);
            statusFixture.setCreatedAt(date);
            statusFixture.setUser(userFixture);

            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweet, date, id, parsedUser);

            // save to list
            testStatuses.add(statusFixture);
            expectedResults.add(parsedStatus);
        }
        // Mock dependency's logic
        Mockito.when(twitterInstance.getUserTimeline()).thenReturn(testStatuses);

        // Verify values
        for (int i=0; i<tweets.length; i++) {
            assertEquals(expectedResults.get(i), twitterService.getUserTimeline().get(i));
        }
    }

    @Test
    public void testGetHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        // twitterInstance.getHomeTimeline() returns a ResponseList
        ResponseList<twitter4j.Status> testStatuses = new ResponseListFixture<>();
        // TwitterService.getHomeTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        StatusFixture statusFixture;
        UserFixture userFixture;
        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        // Construct the list of twitter4j.Statuses to be mocked
        for (String tweet : tweets) {
            statusFixture = new StatusFixture();
            userFixture = new UserFixture();

            // Construct twitter4j's response
            userFixture.setName(name);
            userFixture.setScreenName(screenName);
            userFixture.setProfileImageURL(profileImageURL);
            statusFixture.setText(tweet);
            statusFixture.setCreatedAt(date);
            statusFixture.setUser(userFixture);

            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweet, date, id, parsedUser);

            // save to list
            testStatuses.add(statusFixture);
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
        ResponseList<twitter4j.Status> testStatuses = new ResponseListFixture<>();

        StatusFixture statusFixture;
        UserFixture userFixture;
        int count = 0; // counts the occurrences of 'query' in tweets[]

        // Construct the list of twitter4j.Statuses to be mocked
        for (int i=0; i<tweets.length;i++) {
            if (tweets[i].contains(query)) {
                count++;
            }

            statusFixture = new StatusFixture();
            userFixture = new UserFixture();

            // Construct twitter4j's response
            userFixture.setName(name);
            userFixture.setScreenName(screenName);
            userFixture.setProfileImageURL(profileImageURL);
            statusFixture.setText(tweets[i]);
            statusFixture.setCreatedAt(date);
            statusFixture.setUser(userFixture);

            // save to list
            testStatuses.add(statusFixture);
        }
        // Mock dependency's logic
        Mockito.when(twitterInstance.getHomeTimeline()).thenReturn(testStatuses);
        assertEquals(count, twitterService.searchHomeTimeline(query).size());
    }
}
