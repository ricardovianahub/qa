package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0003DashService {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test() {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/dash/a/b/c", String.class);
        assertEquals("a-b-c", response);
    }

    @ParameterizedTest
    @CsvSource({"a-b-c,a,b,c", "this-is-another,this,is,another", "123-456-789,123,456,789", "testing-123-abc,testing,123,abc"})
    void testDash(String expected, String one, String two, String three) {
        String response = testRestTemplate.getForObject(
                "http://server1.onlinebunker.com/dash/" +
                        one +
                        "/" +
                        two +
                        "/" +
                        three,
                String.class
        );
        assertEquals(expected, response);
    }

    // CHALLENGE
    // Write a new test that will return the following expected results:
    // hello-world-hello
    // 1-2-3
    // -----
    // I-did-it

    @ParameterizedTest
    @CsvSource({"hello-world-hello,hello,world,hello", "1-2-3,1,2,3", "-----,-,-,-", "I-did-it,I,did,it"})
    void response(String expected, String one, String two, String three) {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/dash/" + one + "/" + two + "/" + three, String.class);
        assertEquals(expected, response);
    }

}

// what does this service do? it receives 3 parameters and returns them with hyphens/dashes between them
// If it receives a b c it will return a-b-c
// So what should be my 3 parameters if I am expecting ----- ?
// -----
// a-b-c
//
// To ensure that test will run without the "Test not found" type of message, make sure that your test is being
// executed by IntelliJ, not Gradle
// How do you do that? File > Settings > (Search for "Gradle") then follow the steps in the video
// If this is confusing, I can reconfigure your IntelliJs during our live sessions. This only needs to be done
// once per local project
// After you do this, delete all test profiles (see video)
