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
        String response = testRestTemplate.getForObject("http://ricbox.com/division/2", String.class);
        assertEquals("4", response);
    }

    // Design a service called Division that will receive 2 parameters and return the result of
    // the second one divided by the first

    // You create the results that will be used in a parameterized test to ensure that this new service
    // Is doing what's expected
    //
    // http://ricbox.com/division/ - 3 parameters - 1 expected 2 factors
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

}
