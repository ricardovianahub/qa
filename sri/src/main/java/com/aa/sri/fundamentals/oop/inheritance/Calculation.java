package com.aa.sri.fundamentals.oop.inheritance;

interface Calculation { // also an "IS A" relationship. So, Multiplication IS A Calculation, so inheritance is appropriate
    float calculate(float number1, float number2);
    String label();
}
