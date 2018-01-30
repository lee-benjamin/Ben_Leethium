package com.benjamin.benleethium.services;

import com.benjamin.benleethium.api.PostResponse;
import com.benjamin.benleethium.api.ErrorResponse;
import com.benjamin.benleethium.BenLeethiumApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;

public class Post {

    private static final Post INSTANCE = new Post();
    private final Twitter twitterInstance;
    private static final int MAX_CHAR_LIMIT = 280;

    private Post() {
        twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();
    }

    public static Post getInstance() {
        return INSTANCE;
    }

    public boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() < MAX_CHAR_LIMIT);
    }

    public Response updateStatus(String tweet) {
        try {
            logger.debug("Validating tweet before attempting to post.");
            if (this.validateTweet(tweet)) {
                twitterInstance.updateStatus(tweet);
                logger.debug("Successfully posted tweet: " + tweet);
                return Response.ok(new PostResponse(tweet)).build();
            }
            logger.debug("Tweet NOT validated, malformed tweet body.");
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + MAX_CHAR_LIMIT + " characters"))
                .build();
        } catch (TwitterException e) {
            logger.warn("Unable to post the tweet.", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("There is a problem with the server. Please try again later"))
                .build();
        }
    }
}
