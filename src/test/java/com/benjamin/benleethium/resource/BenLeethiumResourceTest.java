package com.benjamin.benleethium.resource;

import com.benjamin.benleethium.models.UpdateStatusRequest;
import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.services.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.mockito.Mockito;
import twitter4j.TwitterException;


public class BenLeethiumResourceTest {

    private TwitterService twitterService;
    private BenLeethiumResource benLeethiumResource;

    @Before
    public void setUp() {
        twitterService = Mockito.mock(TwitterService.class);
        benLeethiumResource = new BenLeethiumResource(twitterService);
    }

    @Test
    public void testGetUserTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        // TwitterService.getHomeTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        for (String tweet : tweets) {
            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweet, date, id, parsedUser);

            // save to list
            expectedResults.add(parsedStatus);
        }
        // mock Response from REST endpoint
        Mockito.when(twitterService.getUserTimeline()).thenReturn(expectedResults);
        Response response = benLeethiumResource.getUserTimeline();

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<Status> statuses = (List<Status>) response.getEntity();
        for (int i=0; i<tweets.length; i++) {
            assertEquals(tweets[i], statuses.get(i).getText());
        }
    }

    @Test
    public void testGetUserTimelineException() throws TwitterException {
        Mockito.when(twitterService.getUserTimeline()).thenThrow(TwitterException.class);
        Response response = benLeethiumResource.getUserTimeline();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testGetHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        // TwitterService.getHomeTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        for (String tweet : tweets) {
            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweet, date, id, parsedUser);

            // save to list
            expectedResults.add(parsedStatus);
        }
        // mock Response from REST endpoint
        Mockito.when(twitterService.getHomeTimeline()).thenReturn(expectedResults);
        Response response = benLeethiumResource.getHomeTimeline();

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<Status> statuses = (List<Status>) response.getEntity();
        for (int i=0; i<tweets.length; i++) {
            assertEquals(tweets[i], statuses.get(i).getText());
        }
    }

    @Test
    public void testGetHomeTimelineException() throws TwitterException {
        Mockito.when(twitterService.getHomeTimeline()).thenThrow(TwitterException.class);
        Response response = benLeethiumResource.getHomeTimeline();

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testReplyToStatus() throws TwitterException, IOException {
        String message = "A tweet a day doth a healthy bird make.";
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        long replyId = 1l;
        Date date = new Date();

        User parsedUser = new User(name, screenName, profileImageURL);
        Status parsedStatus = new Status(message, date, id, parsedUser);

        // mock Response from REST endpoint
        Mockito.when(twitterService.replyToStatus(replyId, message)).thenReturn(parsedStatus);
        Response response = benLeethiumResource.replyToStatus(new UpdateStatusRequest(replyId, message));

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(message, ((Status) response.getEntity()).getText());
    }

//   @Test
//   public void testUpdateStatusException() throws TwitterException, IOException {
//       String message = "tweet";
//
//       Mockito.when(twitterService.updateStatus(message)).thenThrow(TwitterException.class);
//       Response response = benLeethiumResource.updateStatus(new UpdateStatusRequest(message));
//
//       assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
//   }
//
//   @Test
//   public void testUpdateStatusMalformed() throws TwitterException, IOException {
//       String badTweet = new String(new char[TwitterService.MAX_CHAR_LIMIT + 1]);
//       Mockito.when(twitterService.updateStatus(badTweet)).thenThrow(RuntimeException.class);
//       Response response = benLeethiumResource.updateStatus(new UpdateStatusRequest(badTweet));
//       assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
//   }

    @Test
    public void testUpdateStatus() throws TwitterException, IOException {
        String message = "A tweet a day doth a healthy bird make.";
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        User parsedUser = new User(name, screenName, profileImageURL);
        Status parsedStatus = new Status(message, date, id, parsedUser);

        // mock Response from REST endpoint
        Mockito.when(twitterService.updateStatus(message)).thenReturn(parsedStatus);
        Response response = benLeethiumResource.updateStatus(new UpdateStatusRequest(message));

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(message, ((Status) response.getEntity()).getText());
    }

    @Test
    public void testUpdateStatusException() throws TwitterException, IOException {
        String message = "tweet";

        Mockito.when(twitterService.updateStatus(message)).thenThrow(TwitterException.class);
        Response response = benLeethiumResource.updateStatus(new UpdateStatusRequest(message));

        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void testUpdateStatusMalformed() throws TwitterException, IOException {
        String badTweet = new String(new char[TwitterService.MAX_CHAR_LIMIT + 1]);
        Mockito.when(twitterService.updateStatus(badTweet)).thenThrow(RuntimeException.class);
        Response response = benLeethiumResource.updateStatus(new UpdateStatusRequest(badTweet));
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(), response.getStatus());
    }

    @Test
    public void testSearchHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String query = "tweet"; // No search will actually occur during this test
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        String id = "0";
        Date date = new Date();

        List<Status> expectedResults = new ArrayList<>();

        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        for (String tweet : tweets) {
            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweet, date, id, parsedUser);

            // save to list
            expectedResults.add(parsedStatus);
        }
        // mock Response from REST endpoint
        Mockito.when(twitterService.searchHomeTimeline(query)).thenReturn(expectedResults);
        Response response = benLeethiumResource.searchHomeTimeline(query);

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        List<Status> statuses = (List<Status>) response.getEntity();
        for (int i=0; i<tweets.length; i++) {
            assertEquals(tweets[i], statuses.get(i).getText());
        }
    }

    @Test
    public void testSearchHomeTimelineException() throws TwitterException {
        String tweet = "tweet";
        Mockito.when(twitterService.searchHomeTimeline(tweet)).thenThrow(TwitterException.class);
        Response response = benLeethiumResource.searchHomeTimeline(tweet);
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
}

