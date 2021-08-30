package com.aa.sri.fundamentals.oop.inheritance;

class Multiplication implements Calculation {
    @Override
    public String label() {
        return "Multiplication";
    }

    @Override
    public float calculate(float number1, float number2) {
        return number1 * number2;
    }
}
