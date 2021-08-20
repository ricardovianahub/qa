package com.aa.sri.fundamentals.oop;

import java.util.Date;

public class RevertNamesAge {
    public String revert(String firstName, String lastName, int age) {

        int year = (new Date()).getYear() + 1900 - age;

        return getReverse(lastName)
                + " "
                + getReverse(firstName)
                + " "
                + year;
    }

    private StringBuilder getReverse(String name) {
        return new StringBuilder(name).reverse();
    }
}
