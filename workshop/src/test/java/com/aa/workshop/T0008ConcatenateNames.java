package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
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
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        String result = "";
        for (Map map : lines) {
            if (map.get("origination").equals("DFW")) {
                result = result + map.get("firstName");
            }
        }
        assertEquals("JamesJimesJomesJumesJymes", result);
    }

    @Test
    void concatenateFirstNames2() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        String result = "";
        for (Map map : lines) {
            if (map.get("origination").equals("DFW") && map.get("residence").equals("DAL")) {
                result = result + map.get("firstName") + map.get("residence");
            }
        }
        assertEquals("JamesDALJimesDALJomesDALJumesDALJymesDAL", result);
        System.out.print(result);

    }

    //Read passenger service. Count how many passengers have three or more aeiou in their first names
    @Test
    void threeOrMoreVowlesInFirstName() throws JsonProcessingException {
        String payload = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> passengers = objectMapper.readValue(payload, List.class);
        int paxCount = 0;
        int counter = 0;
        List<String> vowels = new ArrayList<>();
        vowels.add("a");
        vowels.add("e");
        vowels.add("i");
        vowels.add("o");
        vowels.add("u");
        for (Map map : passengers) {
            String firstName = String.valueOf(map.get("firstName"));
            String[] firstNameCharArray = new String[firstName.length()];
            for (int i = 0; i <= firstName.length() - 1; i++) {
                firstNameCharArray[i] = firstName.substring(i, i + 1);
                System.out.println("Char Array is: " + firstNameCharArray[i]);
            }

            for (String vowel : vowels) {
                for (int i = 0; i <= firstNameCharArray.length - 1; i++) {
                    if (firstNameCharArray[i].equalsIgnoreCase(vowel)) {
                        counter++;
                    }
                }

            }
            if (counter >= 3) {
                paxCount++;
            }
            System.out.println("Paxcount in loop" + paxCount);
            counter = 0;
        }

        System.out.println("Counter is " + paxCount);
    }

    //Read passenger service. Count how many passengers have three or more aeiou in their first names
    @Test
    void threeOrMoreVowlesInFirstNameDraft() throws JsonProcessingException {
        String payload = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> passengers = objectMapper.readValue(payload, List.class);
        int pax = 0;
        for (Map map : passengers) {
        String firstName = String.valueOf(map.get("firstName"));
        }
    }}
