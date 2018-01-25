package com.benjamin.benleethium;

import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class Get {

    static final Twitter twitterInstance = TwitterFactory.getSingleton();
    static final int MIN_TWEETS = 3;

    public static String main(String[] args) throws TwitterException {
        if (args.length > 0) {
            return "Incorrect number of arguments. Usage: java Get";
        }
        return getHomeTimeline();
    }

    public static String getHomeTimeline() throws TwitterException {
        List<Status> statuses = twitterInstance.getHomeTimeline();
        if (statuses.size() < MIN_TWEETS) {
            // TODO http response code here
            return "Less than 3 tweets on Home Timeline. Aborting.";
        }

        StringBuilder sb = new StringBuilder();
        for (Status status : statuses) {
            sb.append(status.getUser().getName() + ": " +
                               status.getText() + "\n");
        } 
        return sb.toString();
    }
}
