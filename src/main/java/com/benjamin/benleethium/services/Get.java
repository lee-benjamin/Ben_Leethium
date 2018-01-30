package com.benjamin.benleethium.services;

import com.benjamin.benleethium.BenLeethiumApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> getHomeTimeline() throws TwitterException {
        logger.debug("Retrieving home timeline...");
        List<Status> statuses = twitterInstance.getHomeTimeline();

        List<String> homelineTweets = new ArrayList<>();
        for (Status status : statuses) {
            homelineTweets.add(status.getUser().getName() + ": " +
                               status.getText());
        }
        logger.debug("Got home timeline: {}", homelineTweets);
        return homelineTweets;
    }
}
