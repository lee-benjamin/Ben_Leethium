package com.benjamin.benleethium.models;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    private Status status;

    @Before
    public void setUp() {
        status = new Status();
    }

    @Test
    public void testStatusConstructorDefault() {
        assertNotNull(new Status());
    }

    @Test
    public void testStatusConstructor() {
        String text = "test";
        Date createdAt = new Date();
        User user = new User();
        status = new Status(text, createdAt, user);

        assertEquals(text, status.getText());
        assertEquals(createdAt, status.getCreatedAt());
        assertEquals(user, status.getUser());
    }

    @Test
    public void testSetText() {
        String text = "test";
        status.setText(text);
        assertEquals(text, status.getText());
    }

    @Test
    public void setCreatedAt() {
        status.setCreatedAt(null);
        assertNull(status.getCreatedAt());

        Date date = new Date();
        status.setCreatedAt(date);
        assertNotNull(status.getCreatedAt());
    }

    @Test
    public void testEquals() {
        String text = "test";
        Date date = new Date();
        User user = new User();

        status = new Status(text, date, user);
        Status otherStatus = new Status(text, date, user);
        assertEquals(status, otherStatus);
    }

//    @Test
//    public void testEqualsGranular() {
//        String text = "test";
//        Date date = new Date();
//        User user = new User();
//
//        status = new Status(text, date, user);
//        otherStatus = new Status(text, date, user);
//        assertEquals(status, otherStatus);
//
//        otherUser.setName(name);
//        otherUser.setScreenName(nonsense);
//        assertNotEquals(user, otherUser);
//
//        otherUser.setScreenName(screenName);
//        otherUser.setProfileImageURL(nonsense);
//        assertNotEquals(user, otherUser);
//    }

//    @Test
//    public void testEqualsSymmetric() {
//        String text = "test";
//        Date date = new Date();
//        User user = new User();
//
//        status = new Status(text, date, user);
//        Status otherStatus = new Status(text, date, user);
//
//        assertTrue(otherStatus.equals(status)); // reverse is tested in testEquals
//        assertTrue(status.hashCode() == otherStatus.hashCode());
//    }
}


