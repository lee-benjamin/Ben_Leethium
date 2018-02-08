package com.benjamin.benleethium.models;

import com.benjamin.benleethium.resources.BenLeethiumResource;
import com.benjamin.benleethium.services.TwitterService;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.benjamin.benleethium.models.User;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void testUserDefault() {
        assertNotNull(new User());
    }

    @Test
    public void testUser() {
        String name = "Ben";
        String screenName = "BenLeethium";
        String profileImageURL = "ben.com";
        user = new User(name, screenName, profileImageURL);

        assertEquals(name, user.getName());
        assertEquals(screenName, user.getScreenName());
        assertEquals(profileImageURL, user.getProfileImageURL());
    }

    @Test
    public void testSetName() {
        String name = "Benjamin Lee";
        user.setName(name);
        assertEquals(name, user.getName());
    }

    @Test
    public void testSetScreenName() {
        String screenName = "BenLeethium";
        user.setScreenName(screenName);
        assertEquals(screenName, user.getScreenName());
    }

    @Test
    public void testSetProfileImageURL() {
        String url = "ben.com";
        user.setProfileImageURL(url);
        assertEquals(url, user.getProfileImageURL());
    }

    @Test
    public void testEquals() {
        String name = "Ben";
        String screenName = "BenLeethium";
        String url = "ben.com";

        // At some point each field must not be equal to get full coverage
        user = new User(name, screenName, url);
        User otherUser = new User(name, screenName, url);
        assertEquals(user, otherUser);
    }

    @Test
    public void testEqualsGranular() {
        String name = "Ben";
        String screenName = "BenLeethium";
        String url = "ben.com";
        String nonsense = "what a great test this is";

        // At some point each field must be singularly not equal to get full coverage
        user = new User(name, screenName, url);
        User otherUser = new User(nonsense, screenName, url);
        assertNotEquals(user, otherUser);

        otherUser.setName(name);
        otherUser.setScreenName(nonsense);
        assertNotEquals(user, otherUser);

        otherUser.setScreenName(screenName);
        otherUser.setProfileImageURL(nonsense);
        assertNotEquals(user, otherUser);
    }
}

