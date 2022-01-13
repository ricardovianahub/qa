package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class T0006PassengersService {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    // Confirm/assert that the number of lines in the response is 15

    @Test
    void test() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        assertEquals(15, lines.size());
    }

    // Take every odd row from the list of passengers and concatenate all origination airport codes and return it

    @Test
    void oddRowsOfPassengersConcatenateOriginationAirport() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> passengers = objectMapper.readValue(response, List.class);
        int[] validNumbers = new int[]{1, 3, 5, 7, 9};
        String result = "";
        int counter = 0;
        for (Map passenger : passengers) {
            for (int index = 0; index < validNumbers.length; index++) {
                if (validNumbers[index] == (counter % 10)) {
                    result = result + passenger.get("origination");
                }
            }
            counter++;
        }
        System.out.println(result);
    }

    @Test
    void exampleOfArray() {
        int[] even = new int[] {0,2,4,6,8};
                             // 0 1 2 3 4
        for (int i = 0; i < even.length; i++) {
            System.out.print("in the array even, the index ");
            System.out.print(i);
            System.out.print(" contains ");
            System.out.print( even[i] );

            System.out.println();
        }
    }

    @Test
    void exampleOfRemainder() {
        for (int i = 1; i <= 15; i+=2) {
            System.out.println(i % 10); // % means ' remainder of '
        }
    }

    // 51 divided by 10 remainder of 1
    // 298374239475 divide by 10 remainder 5


//    @Test
//    void testWithPassengerObject() throws JsonProcessingException {
//        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
//        List<Passenger> lines = objectMapper.readValue(response, List.class);
//        System.out.println("Passenger Object example: " + lines.get(0).getFirstName());
//        assertEquals(15, lines.size());
//    }

    @Test
    void test2() throws JsonProcessingException {
        String response = testRestTemplate.getForObject("http://server1.onlinebunker.com/passengers", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        assertEquals(15, lines.size());
    }

    private class Passenger {
        private String firstName;
        private String lastName;
        private String origination;
        private String residence;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getOrigination() {
            return origination;
        }

        public void setOrigination(String origination) {
            this.origination = origination;
        }

        public String getResidence() {
            return residence;
        }

        public void setResidence(String residence) {
            this.residence = residence;
        }
    }

}
