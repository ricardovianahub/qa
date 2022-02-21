package com.aa.sri.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ControllerTest {

    @Test
    void calculatorAdd() {
        CalculatorController calculatorController = new CalculatorController();

        assertEquals(4, calculatorController.add(2, 2));
    }

    @Test
    void calculatorSubtract() {
        CalculatorController calculatorController = new CalculatorController();

        assertEquals(4, calculatorController.subtract(2, 2));
    }

}
