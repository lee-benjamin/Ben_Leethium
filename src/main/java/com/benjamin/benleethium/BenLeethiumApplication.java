package com.benjamin.benleethium;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.health.TemplateHealthCheck;

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
    public void initialize(Bootstrap<BenLeethiumConfiguration> bootstrap) {}

    @Override
    public void run(BenLeethiumConfiguration configuration,
                    Environment environment) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        Twitter4jConfiguration twitter4jConf = configuration.getTwitter4jConfiguration();
        cb.setOAuthConsumerKey(twitter4jConf.getConsumerKey())
            .setOAuthConsumerSecret(twitter4jConf.getConsumerSecret())
            .setOAuthAccessToken(twitter4jConf.getAccessToken())
            .setOAuthAccessTokenSecret(twitter4jConf.getAccessTokenSecret());
        twitterFactory = new TwitterFactory(cb.build());
        logger.info("Twitter OAuth credentials successfully loaded from yml file.");

        final BenLeethiumResource resource = new BenLeethiumResource();
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("Server Up", healthCheck);
    }
}
