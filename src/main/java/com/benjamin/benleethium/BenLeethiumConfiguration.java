package com.benjamin.benleethium;

import io.dropwizard.Configuration;

import twitter4j.conf.ConfigurationBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BenLeethiumConfiguration extends Configuration {
    private static String CONSUMER_KEY;
    private static String CONSUMER_SECRET;
    private static String ACCESS_TOKEN;
    private static String ACCESS_TOKEN_SECRET;

    @Valid
    @NotNull
    private Twitter4jConfiguration twitter4jConf = new Twitter4jConfiguration();



    public Twitter4jConfiguration getTwitter4jConfiguration() {
        return twitter4jConf;
    }

}
  
  
