package com.aa.sri.controller;

import org.springframework.stereotype.Controller;

@Controller
public class SpringCalculatorController {

    // Controllers have no code other than calling other
    // object and passing parameters to them

    private Adder adder;
    private Subtractor subtractor;
    private Multiplier multiplier;

    public SpringCalculatorController(
            Adder adder, Subtractor subtractor, Multiplier multiplier
    ) {
        this.adder = adder;
        this.subtractor = subtractor;
        this.multiplier = multiplier;
    }

    public int add(int i1, int i2) {
        return this.adder.add(i1, i2);
    }

    public int subtract(int i1, int i2) {
        return this.subtractor.subtract(i1, i2);
    }

    public int multiply(int i1, int i2) {
        return this.multiplier.multiply(i1, i2);
    }

}
