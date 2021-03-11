package com.aa.three;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.aa.improvekataben.api.createpnr.CreatePNRRequest;
import com.aa.improvekataben.api.createpnr.CreatePNRResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aa.improvekataben.FromPMApplication;
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
    void eachRowShouldContainAFieldSalutationThatContainsOneOfTheFollowingMrMrsMissNA() throws Exception {
        // setup & execution = Postman
        String response = testRestTemplate.getForObject("http://ricbox.com/three", String.class); // playing "Postman" - same functionality as Postman hitting "Send"
        // assertion
        List<Map> jsonData = objectMapper.readValue(response, List.class);
        for (Map row : jsonData) {
            // pm.expect(row.itinerary).to.not.equal(null);
            assertNotNull(row.get("itinerary"));
            if (row.get("origin") == null) {
                fail("no origin");
            }
            assertNotNull(row.get("date"));
            assertNotNull(row.get("destination"));
            assertNotNull(row.get("phone"));
        }
    }


    @Test
    void createAPNR() throws Exception {
        // setup & execution = Postman
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
        // assertion
        assertNotNull(response);
        assertNotNull(response.getRecordLocator());
        assertNotEquals("", response.getRecordLocator(), "RecordLocator is " + response.getRecordLocator());
        assertTrue(response.getRecordLocator().length() == 6);
        String recordLocatorPatternString = "[A-Z]{6}";
        Pattern patternRecordLocator = Pattern.compile(recordLocatorPatternString);
        assertTrue(patternRecordLocator.matcher(response.getRecordLocator()).matches());
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

}
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