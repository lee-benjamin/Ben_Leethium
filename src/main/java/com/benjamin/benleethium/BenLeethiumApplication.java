package com.benjamin.benleethium;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.health.TemplateHealthCheck;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class BenLeethiumApplication extends Application<BenLeethiumConfiguration> {
    public static void main(String[] args) throws Exception {
        new BenLeethiumApplication().run(args);
    }

    @Override
    public String getName() {
        return "BenLeethium";
    }

    @Override
    public void initialize(Bootstrap<BenLeethiumConfiguration> bootstrap) {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey(Twitter4jConfiguration.CONSUMER_KEY)
            .setOAuthConsumerSecret(Twitter4jConfiguration.CONSUMER_SECRET)
            .setOAuthAccessToken(Twitter4jConfiguration.ACCESS_TOKEN)
            .setOAuthAccessTokenSecret(Twitter4jConfiguration.ACCESS_TOKEN_SECRET);
        TwitterFactory tf = new TwitterFactory(cb.build());
    }

    @Override
    public void run(BenLeethiumConfiguration configuration,
                    Environment environment) {
        final BenLeethiumResource resource = new BenLeethiumResource();
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("Server Up", healthCheck);
    } 
}
