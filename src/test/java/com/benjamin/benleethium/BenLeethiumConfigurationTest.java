package com.benjamin.benleethium;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertEquals;

public class BenLeethiumConfigurationTest {

    private BenLeethiumConfiguration conf;

    @Test
    public void setGetTwitter4jConfiguration() {
        conf = new BenLeethiumConfiguration();
        assertNotNull(conf.getTwitter4jConfiguration());
    }

    @Test
    public void setIsMockData() {
        conf = new BenLeethiumConfiguration();
        boolean value = true;
        conf.setIsMockData(value);
        assertEquals(value, conf.getIsMockData());
    }
}
