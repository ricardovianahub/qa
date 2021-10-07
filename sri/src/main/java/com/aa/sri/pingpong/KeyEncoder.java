package com.aa.sri.pingpong;

public class KeyEncoder {

    public String createKey(String firstName, String lastName, String origination) {
        guardCreateKey(firstName, lastName, origination);

        return firstName + "-" + lastName + "-" + origination;
    }

    private void guardCreateKey(String firstName, String lastName, String origination) {
        if (firstName == null || lastName == null || origination == null) {
            throw new IllegalArgumentException();
        }
    }
}
