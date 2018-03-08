package com.benjamin.benleethium.models;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UpdateStatusRequestTest {

    @Test
    public void testSetMessage() {
        String message = "test";
        UpdateStatusRequest updateStatusRequest = new UpdateStatusRequest();
        updateStatusRequest.setMessage(message);
        assertEquals(message, updateStatusRequest.getMessage());
    }
}
