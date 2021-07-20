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
public class T0008ConcatenateNames {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testJulian() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("origination").equals("DFW")) {
                foundIt = true;
            }
        }
        assertTrue(foundIt);
    }

    @Test
    void concatenateSeveralStrings() {
        String a = "The quick brown fox";
        String b = "jumps over the";

        String result = a + " " + b + " lazy dog";

        assertEquals("The quick brown fox jumps over the lazy dog", result);
    }

    @Test
    void stringBuiltStepByStep() {
        String result = "";
        result = result + "a";

        assertEquals("a", result);

        result = result + "b";
        assertEquals("ab", result);
    }

    // Assert that the first names of all passengers whose origination is DFW are equal to JamesJimesJomesJumesJymes

    @Test
    void concatenateFirstNames() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        String result = "";
        for (Map map : lines) {
            if (map.get("origination").equals("DFW")) {
                result = result + map.get("firstName");
            }
        }
        assertEquals("JamesJimesJomesJumesJymes", result);
    }
}
