package com.aa.homework.debbie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    void weatherAlertsVTEC() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("https://api.weather.gov/alerts/active?area=TX", String.class);
        Map map = objectMapper.readValue(response, Map.class);

        // features (list)
        // properties
        // parameters
        // VTEC

        List features = (List) map.get("features");
        Map feature = (Map) features.get(0);
        Map properties = (Map) feature.get("properties");
        Map parameters = (Map) properties.get("parameters");
        List vtec = (List) parameters.get("VTEC");
        assertNotNull(parameters.get("VTEC"));
        assertEquals("/O.CON.KEPZ.WI.Y.0005.220221T1900Z-220222T0100Z/", vtec.get(0));
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
        List texasFeatures = (List) map.get("features"); // [ ] - square brackets means list in JSON
                // Anytime you have a generic Object and you want to use it with the specific methods and properties of whatever the class it is, it needs to be CAST

        assertTrue(texasFeatures.size() >= 1);
    }

}
