package com.aa.homework.debbie;

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

import com.aa.workshop.WorkshopApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherGovTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void heartBeat() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("https://api.weather.gov/", String.class);
        Map map = objectMapper.readValue(response, Map.class);

        assertEquals("OK", map.get("status"));
    }

    @Test
    void weatherAlertsTexas() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("https://api.weather.gov/alerts/active?area=TX", String.class);
        Map map = objectMapper.readValue(response, Map.class);

        assertTrue(map.get("title").toString().endsWith("Texas"));
    }

    @Test
    void weatherAlertsNewJersey() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("https://api.weather.gov/alerts/active?area=NJ", String.class);
        Map map = objectMapper.readValue(response, Map.class);

        assertTrue(map.get("title").toString().endsWith("New Jersey"));
    }

    @Test
    void featuresLength() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("https://api.weather.gov/alerts/active?area=TX", String.class);
        Map map = objectMapper.readValue(response, Map.class);
        List texasFeatures = (List) map.get("features");

        assertTrue(texasFeatures.size() >= 1);
    }

}
