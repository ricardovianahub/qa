package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

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
    // "abc " - ? "john doe"
    // "a1b" - ?
    // "abc?" - ?
    // = &
    // http://server.com/service/value1/value2
    // http://server.com/service?param1=value1&param2=value2
    // Backwards compatibility
    // HTML encoding = space %20 - question mark %3F

    @Test
    void alpha() throws URISyntaxException {
        String response1 = testRestTemplate.getForObject(new URI("http://server1.onlinebunker.com/alpha/abc%3F"), String.class);
        assertEquals("false", response1);
        String response2 = testRestTemplate.getForObject("http://server1.onlinebunker.com/alpha/123", String.class);
        assertEquals("false", response2);
        String response3 = testRestTemplate.getForObject(new URI("http://server1.onlinebunker.com/alpha/abc%20"), String.class);
        assertEquals("false", response3);
    }

}
