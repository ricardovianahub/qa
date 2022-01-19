package com.aa.homework.debbie;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;
import java.util.Map;

// when I send pieripa though postman, I want to see response success

public class PieripaTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    private ObjectMapper objectMapper;

    @Test
    void test() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        String response = testRestTemplate.getForObject("http://aacloud.qa.esoa.qcorpaa.aa.com/api/deniedboardingaccomodation/v1/", String.class);
        List<Map> lines = objectMapper.readValue(response, List.class);
        System.out.println(lines.get(0));
        //assertTrue("");
    }
}

