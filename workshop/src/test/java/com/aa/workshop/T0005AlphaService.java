package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0005AlphaService {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // Make a call to a service called alpha which will return "true" if the parameter you send it
    // is all alphabetic characters (upper case, lower case) and "false" if it contains anything else

    // These are the answers that we should try to understand before we run the tests:
    // Which ones of these should be true and which ones should be false?
    // "abc " - ?
    // "a1b" - ?
    // "abc?" - ?

    @Test
    void alpha() {
        String response1 = testRestTemplate.getForObject("http://ricbox.com/alpha/abc", String.class);
        assertEquals("true", response1);
        String response2 = testRestTemplate.getForObject("http://ricbox.com/alpha/123", String.class);
        assertEquals("false", response2);
    }

}