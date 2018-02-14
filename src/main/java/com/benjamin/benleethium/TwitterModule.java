package com.benjamin.benleethium;

import dagger.Provides;
import dagger.Module;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Module
public class TwitterModule {
    private TwitterFactory twitterFactory;

    public TwitterModule(Twitter4jConfiguration twitter4jConfiguration) {
        // Creating a new TwitterFactory via ConfigurationBuilder, reading keys from yml file
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(twitter4jConfiguration.getConsumerKey())
            .setOAuthConsumerSecret(twitter4jConfiguration.getConsumerSecret())
            .setOAuthAccessToken(twitter4jConfiguration.getAccessToken())
            .setOAuthAccessTokenSecret(twitter4jConfiguration.getAccessTokenSecret());

        this.twitterFactory = new TwitterFactory(cb.build());
    }

    @Provides Twitter provideTwitter() {
        return this.twitterFactory.getInstance();
    }
}

