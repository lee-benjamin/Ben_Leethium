package com.benjamin.benleethium.resource;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.services.TwitterService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;
import com.benjamin.benleethium.models.StatusFixture;
import com.benjamin.benleethium.models.UserFixture;
import com.benjamin.benleethium.models.ResponseListFixture;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.mockito.Mockito;
import twitter4j.ResponseList;
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
    public void testGetHomeTimeline() throws TwitterException {
        String[] tweets = {"This is a test.", "Tweeting my cares away.","A tweet a day doth a healthy bird make."};
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        Date date = new Date();

        // TwitterService.getHomeTimeline() returns a List<Status>
        List<Status> expectedResults = new ArrayList<>();

        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status

        for (int i=0; i<tweets.length;i++) {
            // Construct twitterService's expected response
            parsedUser = new User(name, screenName, profileImageURL);
            parsedStatus = new Status(tweets[i], date, parsedUser);

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
    public void testUpdateStatus() throws TwitterException {
        String tweet = "A tweet a day doth a healthy bird make.";
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        Date date = new Date();

        User parsedUser; // stripped version of a twitter4j.User
        Status parsedStatus; // stripped version of a twitter4j.Status
        parsedUser = new User(name, screenName, profileImageURL);
        parsedStatus = new Status(tweet, date, parsedUser);

        // mock Response from REST endpoint
        Mockito.when(twitterService.updateStatus(tweet)).thenReturn(parsedStatus);
        Response response = benLeethiumResource.updateStatus(tweet);

        // verify Response values match Status values
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals(tweet, ((Status) response.getEntity()).getText());
    }

    @Test
    public void testSearchHomeTimeline() {}
}

