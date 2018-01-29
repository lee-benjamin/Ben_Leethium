package com.benjamin.benleethium;

import com.benjamin.benleethium.api.PostResponse;
import com.benjamin.benleethium.api.ErrorResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.ws.rs.core.Response;

public class Post {

    private static final Twitter twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();
    private static final int MAX_CHAR_LIMIT = 280;

    public static void main(String[] args) {}

    public static boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() < MAX_CHAR_LIMIT);
    }

    public static Response updateStatus(String tweet) {
        try {
            if (validateTweet(tweet)) {
                twitterInstance.updateStatus(tweet);
                return Response.ok(new PostResponse(tweet)).build();
            }
            return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + MAX_CHAR_LIMIT + " characters"))
                .build();
        } catch (TwitterException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorResponse("There is a problem with the server. Please try again later"))
                .build();
        }
    }

}
