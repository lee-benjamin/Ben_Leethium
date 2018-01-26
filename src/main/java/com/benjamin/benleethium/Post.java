package com.benjamin.benleethium;

import com.benjamin.benleethium.api.PostResponse;
import com.benjamin.benleethium.api.ErrorResponse;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Post {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MAX_CHAR_LIMIT = 280;

    public static void main(String[] args) throws TwitterException {}

    public static boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() < MAX_CHAR_LIMIT);
    }

    public static Response updateStatus(String tweet) throws TwitterException {
        if (validateTweet(tweet)) {
            twitterInstance.updateStatus(tweet);
            return Response.ok(new PostResponse(tweet), MediaType.APPLICATION_JSON).build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new ErrorResponse("Malformed tweet. Ensure your tweet isn't empty or exceeds " + MAX_CHAR_LIMIT + " characters"))
            .build();
    }

}
