package com.aa.sri.fundamentals.oop;

import java.time.LocalDateTime;

public class RevertNamesAge {
    public String revert(String firstName, String lastName, int age) {
        StringBuilder reversedFirstName = revertName(firstName);
        StringBuilder reversedLastName = revertName(lastName);
        int year = calculateYear(age);

        return formattedResponse(reversedFirstName, reversedLastName, year);
    }

    private StringBuilder revertName(String lastName) {
        StringBuilder reversedLastName = new StringBuilder();
        for (int i = lastName.length() - 1; i >= 0; i--) {
            reversedLastName.append(lastName.charAt(i));
        }
        return reversedLastName;
    }

    private int calculateYear(int age) {
        return LocalDateTime.now().getYear() - age;
    }

    private String formattedResponse(StringBuilder reversedFirstName, StringBuilder reversedLastName, int year) {
        return reversedLastName.toString() + " " + reversedFirstName.toString() + " " + year;
    }
}
