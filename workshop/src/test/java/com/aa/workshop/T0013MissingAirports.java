package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
public class T0013MissingAirports {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper om = new ObjectMapper();

    // Example: Verify that each residence airport is present in the /airport service

    @Test
    void verifyAirportsOfResidence() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> passengers = om.readValue(response  , List.class);
        for (Map passenger : passengers) {
            assertFalse(
                    testRestTemplate.getForObject("http://ricbox.com/airport/" + passenger.get("residence"), String.class)
                            .contains("null")
            );
        }
    }

    // verify if every airport that is present in service /airport is also present in service /airportmissing
    // Generate an output (using System.out.println) that has all the airports that were not found in /airportmissing
    // The test should still fail, but all missing airports should be in the output
    // Output format should be, for example, DFW - JFK - GRU ---- The String " - " should be between each airport code
    // that is missing from /airpormissing

    @Test
    void verifyMissingAirportsOfResidence() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> passengers = om.readValue(response, List.class);
        Boolean missedAirport = false;
        String result = "";
        for (Map passenger : passengers) {
            if ((testRestTemplate.getForObject("http://ricbox.com/airport/" + passenger.get("residence"), String.class)
                    .contains("null"))) {
                missedAirport = true;
                if (!result.equals("")) {
                    result = result + " - ";
                }
                result = result + passenger.get("residence");
            }
            if (testRestTemplate.getForObject("http://ricbox.com/airportmissing/" + passenger.get("residence"), String.class)
                    .contains("null")) {
                missedAirport = true;
                if (!result.equals("")) {
                    result = result + " - ";
                }
                result = result + passenger.get("residence");
            }
        }
        System.out.println("Missing airports: " + result);
        assertTrue(missedAirport);
    }


}
