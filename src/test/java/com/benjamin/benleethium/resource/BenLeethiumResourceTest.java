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
        Mockito.when(twitterService.getHomeTimeline()).thenReturn(expectedResults);
        Response response = benLeethiumResource.getHomeTimeline();

        // check status code
        //  check body
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        //for (int i=0; i<tweets.length; i++) {
        //    assertEquals(tweets[i], expectedResults.get(i).getText());    
        //}
    }

    @Test
    public void testUpdateStatus(){}

    @Test
    public void testSearchHomeTimeline() {}
}

