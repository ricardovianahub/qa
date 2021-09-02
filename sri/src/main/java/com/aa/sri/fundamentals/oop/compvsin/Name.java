package com.aa.sri.fundamentals.oop.compvsin;

public class Name {
    protected String firstName;
    protected String lastName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String abbreviation() {
        return this.firstName.substring(0, 1) + this.lastName.substring(0, 1);
    }

    public String lastFirst() {
        return this.lastName + "," + this.firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
