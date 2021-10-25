package com.aa.workshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T00011FailOnExtendedCharactors {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();


    //Fail the test if any characters provided in the field of the service response is not alphabetical

    @Test
    void failIfNotAlphabeticalCharactersAreNotPresent_BasedOnResponse() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
           for (Map map : lines) {
               String alpha;
               alpha = testRestTemplate.getForObject("http://ricbox.com/alpha/" + map.get("firstName"), String.class);
               assertEquals("true", alpha);
               alpha = testRestTemplate.getForObject("http://ricbox.com/alpha/" + map.get("secondName"), String.class);
               assertEquals("true", alpha);
               alpha = testRestTemplate.getForObject("http://ricbox.com/alpha/" + map.get("origination"), String.class);
               assertEquals("true", alpha);
               alpha = testRestTemplate.getForObject("http://ricbox.com/alpha/" + map.get("residence"), String.class);
               assertEquals("true", alpha);
    }
}

    @Test
    void alphaWithRegularExpression() {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        assertTrue(pattern.matcher("John").matches());
        assertFalse(pattern.matcher("123").matches());

        }


    @Test
    void failIfNotAlphabeticalCharactersAreNotPresent_RegularExpression() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Pattern pattern = Pattern.compile("[a-zA-Z]+"); // Pattern.doesItMatch(map.get("firstName"), "[a-zA-Z]");
        for (Map map : lines) {
           assertTrue(pattern.matcher((CharSequence) map.get("firstName")).matches());
           assertTrue(pattern.matcher((CharSequence) map.get("secondName")).matches());
           assertTrue(pattern.matcher((CharSequence) map.get("origination")).matches());
           assertTrue(pattern.matcher((CharSequence) map.get("residence")).matches());
               }
    }
    }





