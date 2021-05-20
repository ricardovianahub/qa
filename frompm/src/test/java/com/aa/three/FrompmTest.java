package com.aa.three;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

import com.aa.improvekataben.api.createpnr.CreatePNRRequest;
import com.aa.improvekataben.api.createpnr.CreatePNRResponse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aa.improvekataben.FromPMApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FromPMApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FrompmTest {

    @Autowired
    private TestRestTemplate testRestTemplate; // "Postman"

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void ensureServiceThreeHasAllRequiredFields() throws Exception {
        // setup & execution = Postman
        String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
        for (Map row : jsonData) {
            // pm.expect(row.itinerary).to.not.equal(null);
            assertNotNull(row.get("itinerary"));
            assertNotNull(row.get("origin"));
            assertNotNull(row.get("date"));
            assertNotNull(row.get("destination"));
            assertNotNull(row.get("phone"));
            assertNotNull(row.get("name"));
            assertNotNull(row.get("ssr"));
        }
    }

    @Test
    void ensureDestinationAcceptsJustThreeUpperCaseLetters() throws JsonProcessingException {
        // setup & execution = Postman
        String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
        String recordLocatorPatternString = "^[A-Z]{3}$";
        Pattern patternRecordLocator = Pattern.compile(recordLocatorPatternString);
        for (Map row : jsonData) {
            assertTrue(patternRecordLocator.matcher(row.get("destination").toString()).matches(),
                    "Destination does not match pattern " + recordLocatorPatternString + " = " + row.get("destination"));
        }
    }

    @Test
    void ensureDestinationMatchesLastThreeLettersOfItinerary() throws JsonProcessingException {
        // setup & execution = Postman
        String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
        int counter = 0;
        for (Map row : jsonData) {
            counter = counter + 1;
            // Destination (NYC) does not match the last three letters of the itinerary (ORDDFW)
            // Change the message into: Google Java substring
            // Row #1 - There was a problem. NYC is the destination, but the itinerary does not end with it. Instead it ends with DFW
            // how do we know what which row I'm on and how to print it. start from 1
            assertTrue(row.get("itinerary").toString().endsWith(row.get("destination").toString()),
                    "Row #" + counter + " - there was a problem. "
                            + row.get("destination")
                            + " is the destination, but the itinerary does not end with it. Instead it ends with "
                            + row.get("itinerary").toString().substring(3)
            /*Destination (*
            row.get ("destination")
            *) does not match the last three letters of the Itinerary (*
            row.get ("Itinerary")
            ")" */
            );
        }
    }

    //i want atleast 50% of pax residence and origin to be same
    //how much percentage have same residence and origin print percentage
    //http://ricbox.com/passengers"
    @Test
    void ensureAtleastFiftypercentPaxResidenceIsSameasOrigin() throws JsonProcessingException {
        // setup & execution = Postman
        String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
        int match = 0;
        int nomatch = 0;
        for (Map row : jsonData) {
            if ((Objects.equals(row.get("residence"), row.get("origination")))) {
                match = match + 1;
            } else {
                nomatch = nomatch + 1;
            }

        }
        assertTrue(((float) match / (match + nomatch) * 100) >= 50,

                "There are less than 50% pax whose origin and residence does not match. "
                        + "\n"
                        + "No.of pax with matching residence and origin are: "
                        + match
                        + "\n"
                        + "Percentage of pax with matching residence and origin are: "
                        + (float) match / (match + nomatch) * 100
                        + "\n"
                        + "No.of pax without matching residence and origin are: "
                        + nomatch
                        + "\n"
                        + "Percentage of pax without matching residence and origin are: "
                        + (float) nomatch / (match + nomatch) * 100

        );
    }
//not finished
    @Test
    void ensureAtleastFiftypercentPaxDepartFromSameZipcode() throws JsonProcessingException {
        //We want a test that will pass if more than 50% of the passengers take off from the same ZIP code, it not necessarily the same airport
        // there will be two services ricbox.com/passengers ricbox.com/ricbox.com/airport/JFK
        //example syntax: http://ricbox.com/airport/JFK
        //{ "zip" : "75006" }
        String response = testRestTemplate.getForObject("http://ricbox.com/airport", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
    }

    @Test
    void ensureSSROnlyContainsLettersAndNumbersAndEndsWithName () throws JsonProcessingException {
    // setup & execution = Postman
            String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
            // assertion
            List<Map> jsonData = objectMapper.readValue(response, List.class);
            String ssrPatternString =
                    "[A-Za-z0-9]{1}" + // 1st character
                            "[A-Za-z0-9\\s]{1,20}" + // Middle characters
                            "[A-Za-z0-9]{1}"; // Last character
            Pattern patternRecordLocator = Pattern.compile(ssrPatternString);
            for (Map row : jsonData) {
                assertTrue(patternRecordLocator.matcher(row.get("ssr").toString()).matches(),
                        String.format("SSR does not match pattern %s = [%s]",
                                ssrPatternString,
                                row.get("ssr")
                        )
                );
                assertTrue(
                        row.get("ssr").toString()
                                .endsWith(row.get("name").toString()),
                        String.format("SSR did not end with name. SSR = [%s] and name = [%s]",
                                row.get("ssr"),
                                row.get("name")
                        )
                );
            }
        }

        @Test
        void ensureNameHasOnlyLettersSpacesOrHyphens () throws JsonProcessingException {
            // setup & execution = Postman
            String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
            // assertion
            List<Map> jsonData = objectMapper.readValue(response, List.class);
            String recordLocatorPatternString = "^[A-Za-z\\-]+\\s[A-Za-z\\-]+${3,15}";
            Pattern patternRecordLocator = Pattern.compile(recordLocatorPatternString);
            for (Map row : jsonData) {
                assertTrue(patternRecordLocator.matcher(row.get("name").toString()).matches(),
                        "Name does not match pattern " + recordLocatorPatternString + " = " + row.get("name"));
            }
        }

        @Test
        void createAPNR () throws Exception {
            // setup & execution = Postman
            CreatePNRResponse response = callCreatePNR();
            // assertion
            assertNotNull(response);
            assertNotNull(response.getRecordLocator());
            assertNotEquals("", response.getRecordLocator(), "RecordLocator is " + response.getRecordLocator());
            assertEquals(response.getRecordLocator().length(), 6, "current value " + response.getRecordLocator());
            String recordLocatorPatternString = "[A-Z]{6}";
            Pattern patternRecordLocator = Pattern.compile(recordLocatorPatternString);
            assertTrue(patternRecordLocator.matcher(response.getRecordLocator()).matches(),
                    "record locator not matching the pattern six letters upper case "
                            + response.getRecordLocator()
            );
        }

        @Test
        void ensureRecordLocatorsAreDifferentBetweenCalls () {
            CreatePNRResponse response1 = callCreatePNR();
            CreatePNRResponse response2 = callCreatePNR();
            CreatePNRResponse response3 = callCreatePNR();
            assertNotEquals(response1.getRecordLocator(), response2.getRecordLocator());
            assertNotEquals(response2.getRecordLocator(), response3.getRecordLocator());
        }

        private CreatePNRResponse callCreatePNR () {
            CreatePNRResponse response = testRestTemplate.postForObject(
                    "http://ricbox.com/createpnr",
                    new CreatePNRRequest()
                            .setDepartureDate("2021-03-10 18:30")
                            .setOriginCity("DFW")
                            .setDestinationCity("MCO")
                            .setName("John Doe")
                            .setPhone("469-555-1234"),
                    CreatePNRResponse.class
            );
            return response;
        }


//    pm.test("Verify there is a itinerary in PNR", function(){
//            var jsonData = pm.response.json();
//            for(row of jsonData) {
//                pm.expect(row.itinerary).to.not.equal(null);
//                pm.expect(row.origin).to.not.equal(null);
//                if (row.origin == null){
//                    pm.expect.fail("no origin detected");
//                }
//                pm.expect(row.date).to.not.equal(null);
//            }
//        });

//pm.test("Each row should contain a field salutation that contains one of the following:  Mr Mrs Miss N/A", function(){
//        var jsonData = pm.response.json();
//        var expect = true;
//        for(row of jsonData)
//        {
//        if(row.salutation == null )
//        {
//        console.log(" first name "+ row.firstName + " last name " + row.lastName);
//        expect = false;
//        //pm.expect.fail();
//        }
//        else if (row.salutation != "N/A" && row.salutation != "Mr" && row.salutation != "Mrs" && row.salutation != "Miss")
//        {
//        console.log(" first name: "+ row.firstName + " last name: " + row.lastName + " salutation: " + row.salutation);
//        expect = false;
//        }
//        }
//        pm.expect(expect).to.equal(true);
//        });

//new test requirement
// Every time that you call the service/passengers there should be no more than 4 PNRs with origination of LAX
//http://ricbox.com/passengers
//

        @Test
        void ensureNoMoreThanFourPnrsOriginateLAX () throws JsonProcessingException {
            // setup & execution = Postman http://ricbox.com/passengers
            String response = testRestTemplate.getForObject("http://ricbox.com/passengers", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
            // assertion
            List<Map> jsonData = objectMapper.readValue(response, List.class);
            int counter = 0;
            for (Map row : jsonData) {
                if (row.get("origination").equals("LAX")) {
                    counter = counter + 1;
                }
                assertTrue(counter <= 4);
            }
        }
    }


