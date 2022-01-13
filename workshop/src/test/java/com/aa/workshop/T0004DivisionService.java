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
public class T0004DivisionService {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test() {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/division/2/4", String.class);
        assertEquals("2", response);
    }

    // Design a service called Division that will receive 2 parameters and return the result of
    // the second one divided by the first

    // You create the results that will be used in a parameterized test to ensure that this new service
    // Is doing what's expected
    //
    // http://server1.onlinebunker.com/division/ - 3 parameters - 1 expected 2 factors
    //
    // Directions:
    // X 4 scenarios
    // - Once the scenarios are in place, code the test
    // - Use the past services as an example to design the call to the division service

    // Expected result    1st   2nd
    //              2       4     8
    //              5       3    15
    //              3      10    30
    //              9       9    81

    @Test
    void division() {
        assertEquals("2", testRestTemplate.getForObject("http://server1.onlinebunker.com/division/4/8", String.class));
        assertEquals("5", testRestTemplate.getForObject("http://server1.onlinebunker.com/division/3/15", String.class));
        assertEquals("3", testRestTemplate.getForObject("http://server1.onlinebunker.com/division/10/30", String.class));
        assertEquals("9", testRestTemplate.getForObject("http://server1.onlinebunker.com/division/9/81", String.class));
    }

    @Test
    void methodReturnTypes() {
        Calculation calculation = new Calculation();
        assertEquals("4.0", calculation.result(2, 8));
        assertEquals(2000, calculation.somethingElse(123));
        assertEquals("test", calculation.passThrough("test"));
    }

    private class Calculation {
        String result(int first, int second) {
            return String.valueOf((float) second / first);
        }
        int somethingElse(int i) {
            return 2000;
        }
        String passThrough(String param) {
            return param;
        }
    }

}
