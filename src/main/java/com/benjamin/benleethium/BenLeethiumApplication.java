package com.benjamin.benleethium;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.health.TemplateHealthCheck;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

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
        // Allow Cross Origin Resource Sharing
        configureCors(environment);

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

    private static void configureCors(Environment environment) {
        final FilterRegistration.Dynamic cors =
            environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);

        cors.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin,Authorization");
        cors.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET");
        cors.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");

        // Add URL mapping
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
