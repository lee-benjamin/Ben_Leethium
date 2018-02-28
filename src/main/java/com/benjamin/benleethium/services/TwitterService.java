package com.benjamin.benleethium.services;

import com.benjamin.benleethium.models.Status;
import com.benjamin.benleethium.models.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.inject.Inject;

public class TwitterService {

    private static final boolean DEBUG = true;
    public static final int MAX_CHAR_LIMIT = 280;
    private final Logger logger = LoggerFactory.getLogger(TwitterService.class);
    private Twitter twitterInstance;

    @Inject
    public TwitterService(Twitter twitterInstance) {
        this.twitterInstance = twitterInstance;
    }

    public boolean validateTweet(String tweet) {
        return (tweet != null && tweet.length() <= MAX_CHAR_LIMIT);
    }

    public Status updateStatus(String tweet) throws TwitterException, RuntimeException {
        logger.debug("Validating tweet before attempting to post.");
        if (this.validateTweet(tweet)) {
            logger.debug("Tweet valid. Posting tweet...");
            return Stream.of(twitterInstance.updateStatus(tweet))
                                        .findFirst()
                                        .map(s -> new Status(s))
                                        .orElseThrow(NoSuchElementException::new);
        }
        logger.debug("Tweet NOT validated, malformed tweet body.");
        throw new RuntimeException("Tweet body is malformed. Update status aborted.");
    }

    public List<Status> getHomeTimeline() throws TwitterException {
        if (DEBUG) return generateMockedData();

        logger.debug("Retrieving home timeline...");
        return twitterInstance.getHomeTimeline().stream()
                                                .map(s -> new Status(s))
                                                .collect(Collectors.toList());
    }

    public List<Status> searchHomeTimeline(String keyword) throws TwitterException {
        logger.debug("Searching home timeline...");
        return twitterInstance.getHomeTimeline().stream()
                                                .filter(s -> s.getText().contains(keyword))
                                                .map(s -> new Status(s))
                                                .collect(Collectors.toList());
    }

    public static List<Status> generateMockedData() {
        List<Status> statuses = new ArrayList<>();
        String body = "Do not panic, this is only a test.";
        String id = "968228854388183041";
        User user = new User("Benjamin Lee", "Ben_Leethium", "http://pbs.twimg.com/profile_images/956243766146252800/rZY43NJM_normal.jpg");
        for (int i=0;i<15;i++) {
            statuses.add(new Status(body, new Date(), id + i, user));
        }
        return statuses;
    }
}
