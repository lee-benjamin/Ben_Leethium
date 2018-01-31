package com.benjamin.benleethium.services;

import com.benjamin.benleethium.BenLeethiumApplication;
import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;


public class TwitterService {

    public static final int MAX_CHAR_LIMIT = 280;
    private final Logger logger = LoggerFactory.getLogger(TwitterService.class);
    private final Twitter twitterInstance;
    private static TwitterService twitterServiceInstance;

    private TwitterService() {
        twitterInstance = BenLeethiumApplication.twitterFactory.getInstance();
    }

    public static TwitterService getInstance() {
        if (twitterServiceInstance == null) {
            twitterServiceInstance = new TwitterService();
        }
        return twitterServiceInstance;
    }

    public boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() < MAX_CHAR_LIMIT);
    }

    public Status updateStatus(String tweet) throws TwitterException, RuntimeException {
        logger.debug("Validating tweet before attempting to post.");
        if (this.validateTweet(tweet)) {
            Status response;
            logger.debug("Tweet valid. Posting tweet...");
            twitter4j.Status status = twitterInstance.updateStatus(tweet);
            response = new Status(status);
            logger.debug("Successfully posted tweet.");
            return response;
        }
        logger.debug("Tweet NOT validated, malformed tweet body.");
        throw new RuntimeException("Tweet body is malformed. Update status aborted.");
    }

    public List<Status> getHomeTimeline() throws TwitterException {
        logger.debug("Retrieving home timeline...");
        List<twitter4j.Status> statuses = twitterInstance.getHomeTimeline();

        List<Status> homelineTweets = new ArrayList<>();
        for (twitter4j.Status status : statuses) {
            homelineTweets.add(new Status(status));
        }
        logger.debug("Got home timeline.");
        return homelineTweets;
    }
}
