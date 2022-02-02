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
public class T0002AdditionServiceRequimentChange {

    @Autowired
    private TestRestTemplate testRestTemplate;

    // Please call the service http://server1.onlinebunker.com/addition/4/10 and validate that the result is the sum
    // of number being passed

    @Test
    void test() {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/addition/4/10", String.class);
        assertEquals("14", response);
    }

    // Please call the service http://server1.onlinebunker.com/addition/5/8 and validate that the result is the sum
    // of number being passed. Use these parameters:
    //
    // Expected result    x   y
    //              2     1   1
    //              5     3   2
    //           1937  1900  37
    //            100    36  64

    // Both solutions: One test with 4 asserts, and one parameterized test

    @Test
    void additionWithMultipleAsserts() {
        assertEquals("2", testRestTemplate.getForObject("http://server1.onlinebunker.com/addition/1/1", String.class));
        assertEquals("5", testRestTemplate.getForObject("http://server1.onlinebunker.com/addition/3/2", String.class));
        assertEquals("1937", testRestTemplate.getForObject("http://server1.onlinebunker.com/addition/1900/37", String.class));
        assertEquals("100", testRestTemplate.getForObject("http://server1.onlinebunker.com/addition/36/64", String.class));
    }

    @ParameterizedTest
    @CsvSource({"2,1,1", "5,3,2", "1937,1900,37", "100,36,64"})
    void additionWithParameters(String expected, String first, String second) {
        assertEquals(expected,
                testRestTemplate.getForObject(
                        "http://server1.onlinebunker.com/addition/" + first + "/" + second,
                        String.class
                )
        );
    }



}
