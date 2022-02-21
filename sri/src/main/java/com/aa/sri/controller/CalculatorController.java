package com.aa.sri.controller;

public class CalculatorController {

    private Adder adder;
    private Subtractor subtractor;

    public CalculatorController() {
        this.adder = new Adder();
        this.subtractor = new Subtractor();
    }

    public int add(int i1, int i2) {
        return this.adder.add(i1, i2);
    }

    public int subtract(int i1, int i2) {
        return this.subtractor.subtract(i1, i2);
    }
}
