package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
public class T0001MultiplicationServiceRequirementChange {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // Call http://ricbox.com/multiplication service with "2" and expect "4" as a response

    @Test
    void test2() {
        String response = testRestTemplate.getForObject("http://ricbox.com/multiplication/2", String.class);
        assertEquals("4", response);
    }

    // Call http://ricbox.com/multiplication service with "3" and expect "6" as a response
    @Test
    void test3() {
        String response = testRestTemplate.getForObject("http://ricbox.com/multiplication/3", String.class);
        assertEquals("6", response);
    }

    // Call http://ricbox.com/multiplication and expect the following:
    // Sent  -   Received
    //   2           4
    //   3           6
    //  10          20
    // 351         702

    @ParameterizedTest
    @CsvSource({"4,2", "6,3", "20,10", "702,351"})
    void testMultiply(String expected, String parameter) {
        assertNotNull(parameter);
        assertNotNull(expected);
        assertEquals(expected,
                testRestTemplate.getForObject("http://ricbox.com/multiplication/" + parameter, String.class),
                "No match"
        );

    }
    @ParameterizedTest
    @CsvSource({"4,2", "6,3", "20,10", "702,351"})
    void testMultiply2(String expected, String parameter) {
        assertNotNull(parameter);
        assertNotNull(expected);
        assertEquals(expected,
                testRestTemplate.getForObject("http://ricbox.com/multiplication/" + parameter, String.class),
                "No match"
        );
    }
}

