package com.aa.workshop;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = WorkshopApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class T0014RequirementsVsCode {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Each requirement has 3 solutions marked A B C. Which ones correctly implement what is being asked?
    // At least one option is correct. There could be more.
    // The fact that a test passes or not, has nothing to do with whether it reflects the requirements or not
    // The service that is being called could be wrong to. A failing test doesn't mean a wrong test
    // --------------------------------------------------------------------------------------------------------------
    // To go back to the content of the master branch, run this command from the "Terminal" window:
    // git reset --hard

    // 001 Call the passengers service and pass the test only if all passengers' first names start with the letter J

    @Test
    void test001_A() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> salad = objectMapper.readValue(response, List.class);
        for (Map lettuce : salad) {
            assertTrue(lettuce.get("firstName").toString().startsWith("J"));
        }
    }

    @Test
    void test001_B() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> passengers = objectMapper.readValue(response, List.class);
        for (Map passenger : passengers) {
            String.valueOf(passenger.get("lastName")).startsWith("J");
        }
    }

    @Test
    void test001_C() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> paris = objectMapper.readValue(response, List.class);
        for (Map museum : paris) {
            assertEquals(true, ((String) museum.get("firstName")).startsWith("J"));
        }
    }

    // 002 Which one of the following options generates the output 12/12/2021

    @Test
    void test002_A() {
        String day = "12";
        String separator = "/";
        String year = "2021";
        System.out.println(day + separator + day + separator + year);
    }

    @Test
    void test002_B() {
        String date = "12/21/2021";
        System.out.println(date);
    }

    @Test
    void test002_C() {
        System.out.println("12" + "/" + "12 " + "/" + "2021");
    }

    // 003 Which one of the following options will print its name and " success"? And why?
    // Remember: (1 + 1) x 5 = 10 --- however 1 + (1 x 5) = 6
    @Test
    void test003_A() {
        if (2 == 2 && (3 > 8 || 4 < 9)) {
            System.out.println("test003_A success");
        }
    }

    @Test
    void test003_B() {
        if (2 == 2 && 3 > 8 && 4 < 9) {
            System.out.println("test003_B success");
        }
    }

    @Test
    void test003_C() {
        if ((2 < 2 && 3 > 8) || 4 < 9) {
            System.out.println("test003_C success");
        }
    }

    // 004 The passengers from service /passengers should be from the same family. Run a test that will only
    // pass if all of them have the same last name. We should consider that we don't know what last name is

    @Test
    void test004_A() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> family = objectMapper.readValue(response, List.class);
        for (Map person : family) {
            assertTrue("Doe".equals(person.get("lastName")));
        }
    }

    @Test
    void test004_B() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> family = objectMapper.readValue(response, List.class);
        String lastName = null;
        for (Map person : family) {
            if (lastName == null) {
                lastName = String.valueOf(person.get("lastName"));
            } else {
                assertTrue(lastName.equals(person.get("lastName")));
            }
        }
    }

    @Test
    void test004_C() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> family = objectMapper.readValue(response, List.class);
        String lastName = null;
        for (Map person : family) {
            if (lastName == null) {
                lastName = String.valueOf(person.get("lastName"));
            }
            assertTrue("Doe".equals(person.get("lastName")));
        }
    }


}
