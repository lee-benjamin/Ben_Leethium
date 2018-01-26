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

    public static void main(String[] args) throws TwitterException {}

    public static Response getHomeTimeline() throws TwitterException {
        List<Status> statuses = twitterInstance.getHomeTimeline();

        // TODO log this info at DEBUG level
        List<String> homelineTweets = new ArrayList<>();
        for (Status status : statuses) {
            homelineTweets.add(status.getUser().getName() + ": " +
                               status.getText());
        }
        return Response.ok(new GetResponse(homelineTweets), MediaType.APPLICATION_JSON).build();
    }
}
