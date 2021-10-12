package com.aa.sri.pingpong.pp007;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PP007Test {

    // Send first name, last name as parameters and return the following (header):
    // Dear Mr. [First Name] [Last Name] (initials with periods)

    @ParameterizedTest
    @CsvSource({
            "Denzil,Washington,Dear Mr. Denzil Washington (D.W.)",
            "Bill,Folds,Dear Mr. Bill Folds (B.F.)",
    })
    void createHeader(String firstName, String lastName, String expected) {
        LetterHeader letterHeader = new LetterHeader();
        String actual = letterHeader.createHeader(firstName, lastName);
        assertEquals(expected, actual);
    }

    @Test
    void createHeaderNegative() {
        LetterHeader letterHeader = new LetterHeader();
        assertThrows(IllegalArgumentException.class,
                () -> letterHeader.createHeader("Bill", null)
        );
        assertThrows(IllegalArgumentException.class,
                () -> letterHeader.createHeader(null, "Washington")
        );
    }

    private interface MyInterface {
        String onlyOne();
    }

    private class MyClass {
        void printItOut(MyInterface myInterface) {
            System.out.println(myInterface.onlyOne());
        }
    }

    @Test
    void testLambda() {
        MyClass myClass = new MyClass();

        MyInterface myInterface = new MyInterface() {
            @Override
            public String onlyOne() {
                return "This is an anonymous class";
            }
        };
        myClass.printItOut(myInterface);

        myClass.printItOut(()-> "This is a lambda");
    }

}
