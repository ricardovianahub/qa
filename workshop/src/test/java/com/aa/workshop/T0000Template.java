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
public class T0000Template {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void test() {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/multiplication/2", String.class);
        assertEquals("4", response);
    }

    @Test
    void test2() {
        String reply = testRestTemplate.getForObject("http://server1.onlinebunker.com/multiplication/2", String.class);
        assertEquals("4", reply);

    }
}
