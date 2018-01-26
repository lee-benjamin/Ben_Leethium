package com.benjamin.benleethium;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;

public class Get {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MIN_TWEETS = 3;

    public static void main(String[] args) throws TwitterException {
        if (args.length > 0) {
            System.out.println("Incorrect number of arguments. Usage: java Get");
        }
        List<String> homelineTweets = getHomeTimeline();
        if (homelineTweets != null) {
            for (String tweet : homelineTweets) {
                // TODO change this to logging
                System.out.println(tweet);
            }
        }
    }

    public static List<String> getHomeTimeline() throws TwitterException {
        List<Status> statuses = twitterInstance.getHomeTimeline();
        if (statuses.size() < MIN_TWEETS) {
            // TODO http response code here
            // LOG "Less than 3 tweets on Home Timeline. Aborting.";
            return null;
        }

        List<String> homelineTweets = new ArrayList<>();
        for (Status status : statuses) {
            homelineTweets.add(status.getUser().getName() + ": " +
                               status.getText());
        } 
        return homelineTweets;
    }
}
