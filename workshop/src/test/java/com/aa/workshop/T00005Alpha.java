package com.aa.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T00005Alpha {

    @Autowired
    private TestRestTemplate testRestTemplate;

    //Make a call to a service called alpha which will return "true" if the parameter you send it
    // is all alphabetic characters (upper case, lower case) and "false" if it contains anything else

    //There are the answers that we should try to understand before we run the test:
    //"abc " - ?
    //"a1b" - ?
    //"abc?" - ?

    @Test
    void test() {
        String response1 = testRestTemplate.getForObject("http://ricbox.com/alpha/abc", String.class);
        assertEquals("true", response1);
        String response2 = testRestTemplate.getForObject("http://ricbox.com/alpha/a1b", String.class);
        assertEquals("false", response2);
        String response3 = testRestTemplate.getForObject("http://ricbox.com/alpha/abc?", String.class);
        assertEquals("true", response3);
    }

}
