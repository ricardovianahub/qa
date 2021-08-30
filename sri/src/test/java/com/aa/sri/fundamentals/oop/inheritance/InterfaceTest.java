package com.aa.sri.fundamentals.oop.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class InterfaceTest {

    // Try to find a real life scenario in AA that a interface + strategy pattern would be
    // useful

    @Test
    void calculations() {
        List<Calculation> calculations = new ArrayList<>();

        calculations.add(new Multiplication());
        calculations.add(new Division());
        calculations.add(new Addition());
        calculations.add(new Subtraction());

        for (Calculation calculation : calculations) {
            System.out.println(
                    "Calculating " + calculation.label() + " = "
                    + calculation.calculate(100, 10)
            );
        }
    }

}
