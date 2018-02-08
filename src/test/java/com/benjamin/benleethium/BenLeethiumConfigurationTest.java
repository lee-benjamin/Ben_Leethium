package com.benjamin.benleethium;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class BenLeethiumConfigurationTest {

    private BenLeethiumConfiguration conf;

    @Test
    public void setGetTwitter4jConfiguration() {
        conf = new BenLeethiumConfiguration();
        assertNotNull(conf.getTwitter4jConfiguration());
    }
}
