package com.benjamin.benleethium;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.health.TemplateHealthCheck;
//import com.example.helloworld.resources.HelloWorldResource;
//import com.example.helloworld.health.TemplateHealthCheck;

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
        // nothing to do yet
    }

    @Override
    public void run(BenLeethiumConfiguration configuration,
                    Environment environment) {
        final BenLeethiumResource resource = new BenLeethiumResource();
        environment.jersey().register(resource);

        final TemplateHealthCheck healthCheck = 
            new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }

}
