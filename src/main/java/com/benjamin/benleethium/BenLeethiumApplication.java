package com.benjamin.benleethium;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import twitter4j.TwitterFactory;

public class BenLeethiumApplication extends Application<BenLeethiumConfiguration> {

    final Logger logger = LoggerFactory.getLogger(BenLeethiumApplication.class);

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
        TwitterModule twitter = new TwitterModule(configuration.getTwitter4jConfiguration());
        logger.info("Twitter OAuth credentials successfully loaded from yml file.");
        BenLeethiumAppComponent component = DaggerBenLeethiumAppComponent.builder()
            .twitterModule(twitter)
            .build();

        // Register resources
        final BenLeethiumResource resource = component.getBenLeethiumResource();
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = new TemplateHealthCheck();
        environment.healthChecks().register("Server Up", healthCheck);
    }
}
