package com.benjamin.benleethium.services;

import com.benjamin.benleethium.BenLeethiumApplication;
import com.benjamin.benleethium.models.Message;
import com.benjamin.benleethium.models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Status;
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

    public Message updateStatus(String tweet) throws TwitterException, RuntimeException {
        logger.debug("Validating tweet before attempting to post.");
        if (this.validateTweet(tweet)) {
            Message message;
            logger.debug("Tweet valid. Posting tweet...");
            Status status = twitterInstance.updateStatus(tweet);
            message = new Message(status);
            logger.debug("Successfully posted tweet.");
            return message;
        }
        logger.debug("Tweet NOT validated, malformed tweet body.");
        throw new RuntimeException("Tweet body is malformed. Update status aborted.");
    }

    public List<Message> getHomeTimeline() throws TwitterException {
        logger.debug("Retrieving home timeline...");
        List<Status> statuses = twitterInstance.getHomeTimeline();

        List<Message> homelineTweets = new ArrayList<>();
        for (Status status : statuses) {
            homelineTweets.add(new Message(status));
        }
        logger.debug("Got home timeline.");
        return homelineTweets;
    }
}
