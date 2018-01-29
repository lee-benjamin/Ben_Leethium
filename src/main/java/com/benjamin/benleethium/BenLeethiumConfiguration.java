package com.benjamin.benleethium;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

import twitter4j.conf.ConfigurationBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BenLeethiumConfiguration extends Configuration {

    @Valid
    @NotNull
    private Twitter4jConfiguration twitter4jConfiguration = new Twitter4jConfiguration();

    public Twitter4jConfiguration getTwitter4jConfiguration() {
        return twitter4jConfiguration;
    }

}
