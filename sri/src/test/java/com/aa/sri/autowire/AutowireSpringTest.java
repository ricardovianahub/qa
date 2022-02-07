package com.aa.sri.autowire;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aa.sri.SriApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SriApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AutowireSpringTest {

    @Autowired // Bean
    private Person person;

    @Test
    void personAndName() {
        assertNotNull(person.getName());
    }

}
