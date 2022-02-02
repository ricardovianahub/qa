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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0009FilterList {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();


//Filter the list that received from the /passengers service to contain onl passengers whose residence is only DAL
//That new list should contain 11 row

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


    @Test
    void andOrExample() {
        //and
        assertTrue((1 < 2) && (3 < 4));

        //or
        assertTrue((1 > 2) || (3 < 4));

    }


    //Filter the list that received from the /passengers service to contain onl passengers whose residence is only DAL
    //and whose origination is DFW

    @Test
    void filterList2() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        List<Map> output = new ArrayList<>();
        for (Map map : lines) {
            if ( map.get("residence").equals("DAL") && map.get("origination").equals("DFW"))  {
                output.add(map);
            }
        }
        assertEquals(5,output.size());
    }

}









