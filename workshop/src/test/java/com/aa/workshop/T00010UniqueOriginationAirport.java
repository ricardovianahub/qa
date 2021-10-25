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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T00010UniqueOriginationAirport {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Test
    void listOfIntergers() {
        List<Integer> listOfIntergers = new ArrayList<>();
        listOfIntergers.add(1);
        listOfIntergers.add(90);
        listOfIntergers.add(34);

        for (Integer integer : listOfIntergers) {
            System.out.println(integer);

        }
    }

    @Test
    void listOfIntergersContains() {
        List<Integer> listOfIntergers = new ArrayList<>();
        listOfIntergers.add(1);
        listOfIntergers.add(90);
        listOfIntergers.add(34);

        assertTrue(listOfIntergers.contains(90));
        assertFalse(listOfIntergers.contains(91));
    }


    //load all records from passenger service and create a new list of string called uniqueOriginationAirports
//it should contain the unique airport of origination across all passengers
//
    @Test
    void uniqueOriginationAirports() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        List<String> uniqueOriginationAirports = new ArrayList<>();
        for (Map map : lines) {
            if (!uniqueOriginationAirports.contains(map.get("origination"))) {
                uniqueOriginationAirports.add((String) (map.get("origination")));
            }

        }
        assertEquals(6, uniqueOriginationAirports.size());
    }
}

// lines (contains origination airports)
// LAX - GRU - LAX - LAX - ORD - YYZ

// uniqueOriginationAirports
// LAX - GRU - ORD - YYZ








