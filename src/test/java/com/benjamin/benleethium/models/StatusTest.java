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
        status = new Status(text, createdAt, 0, user);

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
    public void testSetCreatedAt() {
        status.setCreatedAt(null);
        assertNull(status.getCreatedAt());

        Date date = new Date();
        status.setCreatedAt(date);
        assertNotNull(status.getCreatedAt());
    }

    @Test
    public void testSetId() {
        long id = 5;
        status.setId(id);
        assertEquals(id,status.getId());
    }

    @Test
    public void testEquals() {
        String text = "test";
        Date date = new Date();
        User user = new User();

        status = new Status(text, date, 0, user);
        Status otherStatus = new Status(text, date, 0, user);
        assertEquals(status, otherStatus);
    }

    @Test
    public void testEqualsGranular() {
        // At some point each field must be singularly not equal to get full coverage
        // Additionally, must test against a different class as well as null
        String text = "text";
        Date date = new Date();
        User user = new User("Ben","BenLeethium", "ben.com");

        assertNotEquals(status, null);
        assertNotEquals(status, new User());

        status = new Status(text, date, 0, user);
        assertEquals(status,status);
        Status otherStatus = new Status("diff text", date, 0, user);
        assertNotEquals(status, otherStatus);

        otherStatus.setText(text);
        otherStatus.setCreatedAt(new Date(1,1,1));
        assertNotEquals(status, otherStatus);

        otherStatus = new Status(text, date, 0, new User());
        assertNotEquals(status, otherStatus);
    }

    @Test
    public void testEqualsSymmetric() {
        String text = "test";
        Date date = new Date();
        User user = new User();

        status = new Status(text, date, 0, user);
        Status otherStatus = new Status(text, date, 0, user);

        assertTrue(otherStatus.equals(status)); // reverse is tested in testEquals
        assertTrue(status.hashCode() == otherStatus.hashCode());
    }
}

