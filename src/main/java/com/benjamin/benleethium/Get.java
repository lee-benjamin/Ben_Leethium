package com.benjamin.benleethium;

import com.benjamin.benleethium.api.GetResponse;
import com.benjamin.benleethium.api.ErrorResponse;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class Get {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MIN_TWEETS = 3;

    public static void main(String[] args) throws TwitterException {}

    public static Response getHomeTimeline() throws TwitterException {
        List<Status> statuses = twitterInstance.getHomeTimeline();
        if (statuses.size() < MIN_TWEETS) {
            // LOG "Less than 3 tweets on Home Timeline. Aborting.";
            return Response.status(Response.Status.FORBIDDEN)
                .entity(new ErrorResponse("Less than " + MIN_TWEETS + " tweets on Home Timeline."))
                .build();
        }

        // TODO log this info at DEBUG level or something
        List<String> homelineTweets = new ArrayList<>();
        for (Status status : statuses) {
            homelineTweets.add(status.getUser().getName() + ": " +
                               status.getText());
        } 
        return Response.ok(new GetResponse(homelineTweets), MediaType.APPLICATION_JSON).build();
    }
}
