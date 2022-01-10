package com.aa.sri.pingpong.pp007;

public class LetterHeader {
    public String createHeader(String firstName, String lastName) {
        guardCreateHeader(firstName, lastName);
//        return "Dear Mr. " + firstName + " " + lastName + " ("
//                + firstName.substring(0, 1) + "."
//                + lastName.substring(0, 1) + "."
//                + ")";
        return String.format("Dear Mr. %s %s (%s.%s.)",
                firstName, lastName,
                firstName.charAt(0), lastName.charAt(0));
    }

    private void guardCreateHeader(String firstName, String lastName) {
        if (lastName == null) {
            throw new IllegalArgumentException();
        }
        if (firstName == null) {
            throw new IllegalArgumentException();
        }
    }
}
