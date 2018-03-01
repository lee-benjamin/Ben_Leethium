package com.benjamin.benleethium;

import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class BenLeethiumConfiguration extends Configuration {

    public boolean isMockData;

    @Valid
    @NotNull
    private Twitter4jConfiguration twitter4jConfiguration = new Twitter4jConfiguration();

    public Twitter4jConfiguration getTwitter4jConfiguration() {
        return twitter4jConfiguration;
    }

    void setIsMockData(boolean isMockData) {
        this.isMockData = isMockData;
    }

    public boolean getIsMockData() {
        return this.isMockData;
    }
}
