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
    void serviceCall() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("firstName").equals("John")) {
                foundIt = true;
            }
        }
        assertTrue(foundIt);
    }

    @Test
    void concatenation() {
        String a = "The";
        String b = "quick brown fox";
        String c = "jumped over";

        String actual = a + " " + b + " " + c + " the lazy dog";

        assertEquals("The quick brown fox jumped over the lazy dog", actual);
    }

    // Call the passengers service, and concatenate the first names of all passengers whose origination airport is DFW
    // Expected result: JimesJomesJumesJymes

    @Test
    void concatenateNames() {

    }

}
