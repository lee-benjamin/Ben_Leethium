package com.benjamin.benleethium;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.services.TwitterService;
import com.benjamin.benleethium.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public class BenLeethiumApplication extends Application<BenLeethiumConfiguration> {

    final Logger logger = LoggerFactory.getLogger(BenLeethiumApplication.class);
    public static TwitterFactory twitterFactory;

    public static void main(String[] args) throws Exception {
        new BenLeethiumApplication().run(args);
    }

    @Override
    public String getName() {
        return "BenLeethium";
    }

    @Override
    public void run(BenLeethiumConfiguration configuration,
                    Environment environment) {
        Twitter4jConfiguration twitter4jConf = configuration.getTwitter4jConfiguration();

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(twitter4jConf.getConsumerKey())
            .setOAuthConsumerSecret(twitter4jConf.getConsumerSecret())
            .setOAuthAccessToken(twitter4jConf.getAccessToken())
            .setOAuthAccessTokenSecret(twitter4jConf.getAccessTokenSecret());
        //twitterFactory = new TwitterFactory(cb.build());
        logger.info("Twitter OAuth credentials successfully loaded from yml file.");

        //final BenLeethiumResource resource = new BenLeethiumResource(TwitterService.getInstance());
        TwitterModule twitter = new TwitterModule(cb);
        BenLeethiumAppComponent component = DaggerBenLeethiumAppComponent.builder()
            .twitterModule(twitter)
            .build();
        final BenLeethiumResource resource = component.getBenLeethiumResource();
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("Server Up", healthCheck);
    }
}
