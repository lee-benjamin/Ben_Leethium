package com.benjamin.benleethium;

import com.benjamin.benleethium.api.GetResponse;
import com.benjamin.benleethium.api.ErrorResponse;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

public class Get {

    private static final Twitter twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();

    public static void main(String[] args) {}

    public static Response getHomeTimeline() {
        try {
            List<Status> statuses = twitterInstance.getHomeTimeline();

            // TODO log this info at DEBUG level
            List<String> homelineTweets = new ArrayList<>();
            for (Status status : statuses) {
                homelineTweets.add(status.getUser().getName() + ": " +
                                   status.getText());
            }
            return Response.ok(new GetResponse(homelineTweets)).build();
        } catch (TwitterException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("There is a problem with the server. Please try again later"))
                .build();
        }
    }
}
