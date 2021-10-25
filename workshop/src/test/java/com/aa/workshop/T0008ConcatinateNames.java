package com.aa.workshop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0008ConcatinateNames {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();


//

    @Test
    void testJulian() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        Boolean foundIt = false;
        for (Map map : lines) {
            if (map.get("origination").equals("DFW")) {
                foundIt = true;

                assertTrue(foundIt);

            }
        }
    }

    // Assert that each name of passengers who's origination is DFW are equal to this JamesJimesJomesJumesJymes
    @Test
    void concatinateSeveralString() {
        String a = "James";
        String b = "Jimes";
        String c = "Jomes";
        String d = "Jumes";
        String e = "Jymes";

        String result = a + "" + b  + "" + c + "" + d + "" + e;
        assertEquals("JamesJimesJomesJumesJymes", result);

    }
    @Test
    void concatinateSeveralString1() {
        String a = "James";
        String b = "Jimes";
        String c = "Jomes";
        String d = "Jumes";
        String e = "Jymes";

        String result = a + " " + b  + " " + c + " " + d + " " + e;
        assertEquals("James Jimes Jomes Jumes Jymes", result);

    }

    @Test
    void concatinateSeveralString2() {
        String a = "James";
        String b = "Jimes";
        String c = "Jomes";
        String d = "Jumes";
        String e = "Jymes";

        String result = a +  b  +  c +  d +  e;
        assertEquals("JamesJimesJomesJumesJymes", result);

    }
}
