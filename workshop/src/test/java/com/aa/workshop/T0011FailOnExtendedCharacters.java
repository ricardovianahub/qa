package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

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
public class T0011FailOnExtendedCharacters {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Fail the test if any character provided in a field of the service response is not alphabetical

    @Test
    void failIfNonAlphabeticalCharactersArePresent_BasedOnResponse() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        for (Map map : lines) {
            String alpha;
            alpha = testRestTemplate.getForObject("http://server1.onlinebunker.com/alpha/" + map.get("firstName"), String.class);
            assertEquals("true", alpha);
            alpha = testRestTemplate.getForObject("http://server1.onlinebunker.com/alpha/" + map.get("secondName"), String.class);
            assertEquals("true", alpha);
            alpha = testRestTemplate.getForObject("http://server1.onlinebunker.com/alpha/" + map.get("origination"), String.class);
            assertEquals("true", alpha);
            alpha = testRestTemplate.getForObject("http://server1.onlinebunker.com/alpha/" + map.get("residence"), String.class);
            assertEquals("true", alpha);
        }
    }

    @Test
    void alphaWithRegularExpressions() {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        assertTrue(pattern.matcher("John").matches());
        assertFalse(pattern.matcher("123").matches());
        assertFalse(pattern.matcher("Conceição").matches());
    }

    @Test
    void failIfNonAlphabeticalCharactersArePresent_RegularExpression() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        for (Map map : lines) {
            assertTrue(pattern.matcher(String.valueOf(map.get("firstName"))).matches());
            assertTrue(pattern.matcher(String.valueOf(map.get("secondName"))).matches());
            assertTrue(pattern.matcher(String.valueOf(map.get("origination"))).matches());
            assertTrue(pattern.matcher(String.valueOf(map.get("residence"))).matches());
        }
    }

    @Test
    void failIfNonAlphabeticalCharactersArePresent_FullResponse() {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        Pattern pattern = Pattern.compile("[a-zA-Z\\[\\]{},\":]+");
        assertTrue(pattern.matcher(response).matches());
    }

    @Test
    void failIfNonAlphabeticalCharactersArePresent_Replace() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        String filteredResponse = response
                .replace('"', ' ')
                .replace(':', ' ')
                .replace(',', ' ')
                .replace('[', ' ')
                .replace(']', ' ')
                .replace('{', ' ')
                .replace('}', ' ');
        Pattern pattern = Pattern.compile("[a-zA-Z ]+");
        assertTrue(pattern.matcher(filteredResponse).matches());
    }

    @Test
    void replaceExample() {
        System.out.println("Workshop".replace('o', '0'));
    }

}
