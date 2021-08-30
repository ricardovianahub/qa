package com.aa.sri.fundamentals.oop.inheritance;

class Subtraction implements Calculation {
    @Override
    public String label() {
        return "Subtraction";
    }

    @Override
    public float calculate(float number1, float number2) {
        return number1 - number2;
    }
}
