package com.aa.sri.mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class MockitoTest {

    private static class One {
        String method() {
            return "Hello";
        }
    }

    @Test
    void mockMe() {
        One one = mock(One.class);
        when(one.method()).thenReturn("Changed");
        //
        System.out.println(one.method());
    }

}
