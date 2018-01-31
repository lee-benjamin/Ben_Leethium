package com.benjamin.benleethium.services;

import com.benjamin.benleethium.BenLeethiumApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;

public class Post {

    private static final Post INSTANCE = new Post();
    private final Twitter twitterInstance;
    public static final int MAX_CHAR_LIMIT = 280;
    final Logger logger = LoggerFactory.getLogger(Post.class);

    private Post() {
        twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();
    }

    public static Post getInstance() {
        return INSTANCE;
    }

    public boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() < MAX_CHAR_LIMIT);
    }

    public String updateStatus(String tweet) throws TwitterException, RuntimeException {
        logger.debug("Validating tweet before attempting to post.");
        if (this.validateTweet(tweet)) {
            logger.debug("Tweet valid. Posting tweet...");
            twitterInstance.updateStatus(tweet);
            logger.debug("Successfully posted tweet: " + tweet);
            return tweet;
        }
        logger.debug("Tweet NOT validated, malformed tweet body.");
        throw new RuntimeException("Tweet body is malformed. Update status aborted.");
    }
}
