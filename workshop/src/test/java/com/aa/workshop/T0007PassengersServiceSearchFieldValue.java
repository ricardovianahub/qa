package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0007PassengersServiceSearchFieldValue {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Confirm that at least one passenger has an origination airport of YYZ

    @Test
    void testYYZ() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("origination").equals("YYZ")) {
                foundIt = true;
            }
        }
        assertTrue(foundIt);
    }

    // Confirm that at least one passenger has the first name Julian

    @Test
    void testJulian() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("firstName").equals("Julian")) {
                foundIt = true;
            }
        }
        assertTrue(foundIt);
    }

    @Test
    void testJulian2() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("lastName").equals("Doe")) {
                foundIt = true;
            }
        }
        assertTrue(foundIt);
    }
}