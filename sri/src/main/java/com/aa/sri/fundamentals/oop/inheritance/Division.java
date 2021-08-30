package com.aa.sri.fundamentals.oop.inheritance;

class Division implements Calculation {
    @Override
    public String label() {
        return "Division";
    }

    @Override
    public float calculate(float number1, float number2) {
        return number1 / number2;
    }
}
