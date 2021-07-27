package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
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
public class T0012AssertNotNull {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void test() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> maps = objectMapper.readValue(response, List.class);
        for (Map map : maps) {
            assertNotNull(map.get("firstName"));
        }
    }

    @Test
    void differencesBetweenEmptyAndNull() {
        // Null = absence
        // Empty = presence of an empty container

        String string1 = null; // = no box
        assertNull(string1);
        String string2 = ""; // = box is there, but there's nothing in it
        assertNotNull(string2);
        Map<String, String> map = new HashMap<>();
        map.put("first", "001");
        assertNotNull(map.get("first"));
        assertNull(map.get("second"));
    }

    // Create a test that will ensure that NONE of the records returned by the /passengers service contains
    // a field called "thirdName"

    @Test
    void ensureNoRecordsHaveFieldThirdName() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> maps = objectMapper.readValue(response, List.class);
        for (Map map : maps) {
            assertNull(map.get("thirdName"));
        }
    }


}
