package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class T0015FundamentalIf {

    @Test
    void ifStatementExample() {
        String test = "abc";

        if (test.equals("abc")) {
            System.out.println("success");
        }
        if (true) {
            System.out.println("success");
        }
        if (2 == 2) {
            System.out.println("success");
        }

        if (test == null) {
            System.out.println("it's null");
        }
        if (test != null) {
            System.out.println("it's not null");
        }

        if (test == null) {
            System.out.println("it's null");
        } else {
            System.out.println("it's not null");
        }

        test = "Something else";
        if (test == null)
            System.out.println("it's null");

        test = "Default value";

        assertEquals("Something else", test);
    }

    // Requirement - Given a string called content:
    // - In case the string is not equal to "american":
    //      - print out "OA flight"
    //      - Fail the test
    // - Print out "BEGIN" and "END" and the beginning and end
    //   of the test

    @ParameterizedTest
    @CsvSource({"american", "another"})
    void ifStatementChallenge(String content) {
        System.out.println("BEGIN");

        if (!content.equals("american")) {
            System.out.println("OA flight");
            fail();
        }

        System.out.println("END");
    }

    @Test
    void ifStatementBrackets() {
        String mom = "hjk";

        if (!mom.equals("hjk"))
            System.out.println("child one");
            System.out.println("child two");
            System.out.println("child three");

        if (!mom.equals("hjk")) {
            System.out.println("dog one");
            System.out.println("dog two");
            System.out.println("dog three");
        }
    }

}
