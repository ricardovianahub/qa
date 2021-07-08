package com.aa.workshop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0001Multiply {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test() {
        String response = testRestTemplate.getForObject("http://ricbox.com/multiplication/2", String.class);
        assertEquals("4", response);
    }

    @ParameterizedTest
    @CsvSource({"4,2", "6,3", "20,10", "702,351"})
    void testMultiply(String expected, String parameter) {
        assertNotNull(parameter);
        assertNotNull(expected);
        assertEquals(expected,
                testRestTemplate.getForObject("http://ricbox.com/multiplication/" + parameter, String.class),
                "No match");

    }

}
