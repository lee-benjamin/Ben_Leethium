package com.benjamin.benleethium.api;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static junit.framework.TestCase.assertNotNull;


public class ErrorResponseTest {

    private ErrorResponse errorResponse;

    @Test
    public void testErrorResponseConstructor() {
        errorResponse = new ErrorResponse("");
        assertNotNull(errorResponse);
    }

    @Test
    public void testGetMessage() {
        String message = "This is an error message, hold on to your stacks!";
        errorResponse = new ErrorResponse(message);
        assertEquals(message, errorResponse.getMessage());
    }
}

