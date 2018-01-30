package com.benjamin.benleethium.services;

import com.benjamin.benleethium.api.GetResponse;
import com.benjamin.benleethium.api.ErrorResponse;
import com.benjamin.benleethium.BenLeethiumApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

public class Get {

    private static final Get INSTANCE = new Get();
    private final Twitter twitterInstance;
    final Logger logger = LoggerFactory.getLogger(Get.class);

    private Get() {
        twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();
    }

    public static Get getInstance() {
        return INSTANCE;
    }

    public Response getHomeTimeline() {
        try {
            logger.debug("Retrieving home timeline...");
            List<Status> statuses = twitterInstance.getHomeTimeline();

            List<String> homelineTweets = new ArrayList<>();
            for (Status status : statuses) {
                homelineTweets.add(status.getUser().getName() + ": " +
                                   status.getText());
            }
            logger.debug("Got home timeline: {}", homelineTweets);
            return Response.ok(new GetResponse(homelineTweets)).build();
        } catch (TwitterException e) {
            logger.warn("Unable to fetch home timeline.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("There is a problem with the server. Please try again later"))
                .build();
        }
    }
}
