package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
public class T0009FilteredList {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Filter the list received from the /passengers service to contain only passengers whose residence is DAL
    // That new list should contain 11 rows

    @Test
    void filterList1() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        List<Map> output = new ArrayList<>();
        for (Map map : lines) {
            if (map.get("residence").equals("DAL")) {
                output.add(map);
            }
        }
        assertEquals(11, output.size());
    }

    @Test
    void orAndExample() {
        // AND
        assertTrue( (1 < 2) && (3 < 4) );

        // OR
        assertTrue( (1 > 2) || (3 < 4) );
    }

    // Challenge
    //
    // Filter the list received from the /passengers service to contain only passengers whose residence is DAL
    // AND whose origination is DFW
    //

}
