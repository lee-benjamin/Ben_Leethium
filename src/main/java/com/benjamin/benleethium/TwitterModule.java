package com.benjamin.benleethium;

import dagger.Provides;
import dagger.Module;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Module
public class TwitterModule {
    private TwitterFactory twitterFactory; 

    public TwitterModule(ConfigurationBuilder cb) {
        this.twitterFactory = new TwitterFactory(cb.build());
    }

    @Provides Twitter provideTwitter() {
        return this.twitterFactory.getInstance();
    }
}

