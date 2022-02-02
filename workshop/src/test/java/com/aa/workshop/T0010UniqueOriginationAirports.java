package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
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
public class T0010UniqueOriginationAirports {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Filter the list received from the /passengers service to contain only passengers whose residence is DAL
    // That new list should contain 11 rows

    @Test
    void filterList1() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        List<Map> output = new ArrayList<>();
        for (Map map : lines) {
            if (map.get("residence").equals("DAL")) {
                output.add(map);
            }
        }
        assertEquals(11, output.size());
    }

    /*
    List<Map>

    - {"firstName":"John","lastName":"Doe","origination":"LAX","residence":"DAL"}
    - {"firstName":"James","lastName":"Doe","origination":"DFW","residence":"DAL"}

    List<Integer>
    - 1
    - 90
    - 34

     */
    @Test
    void listOfIntegers() {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(90);
        listOfIntegers.add(34);

        for (Integer integer : listOfIntegers) {
            System.out.println(integer);
        }
    }

    @Test
    void listOfIntegersContains() {
        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(90);
        listOfIntegers.add(34);

        assertTrue(listOfIntegers.contains(90));
        assertFalse(listOfIntegers.contains(91));
    }

    // Challenge
    //
    // Load all records from the /passengers service and create a new List of Strings called uniqueOriginationAirports
    // It should contain the unique airports of origination across *all* passengers
    //

    /*
    Example:
    Passengers:
        - John, Doe, DFW, DAL
        - Jane, Doe, DFW, DAL
        - John, Smith, ORD, JFK

        In this case, the uniqueOriginationAirports should be ["DFW", "ORD"]. Why? Because those are the 2 unique
        origination airport codes
    */


    @Test
    void uniqueOriginationAirports() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        List<String> uniqueOriginationAirports = new ArrayList<>();
        for (Map map : lines) {
            if (!uniqueOriginationAirports.contains(map.get("origination")) ) {
                uniqueOriginationAirports.add((String) map.get("origination"));
            }
        }
        assertEquals(6, uniqueOriginationAirports.size());
    }

}
