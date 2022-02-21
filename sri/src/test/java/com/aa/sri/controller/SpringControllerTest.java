package com.aa.sri.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.aa.sri.SriApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SriApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringControllerTest {

    @Autowired
    private SpringCalculatorController springCalculatorController;

    @Test
    void calculatorAdd() {
        assertEquals(4, springCalculatorController.add(2, 2));
    }

    @Test
    void calculatorSubtract() {
        assertEquals(0, springCalculatorController.subtract(2, 2));
    }

    @Test
    void calculatorMultiply() {
        assertEquals(4, springCalculatorController.multiply(2, 2));
    }

}
