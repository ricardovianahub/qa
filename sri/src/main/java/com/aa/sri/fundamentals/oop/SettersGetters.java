package com.aa.sri.fundamentals.oop;

public class SettersGetters {

    // To generate setters, getters and constructors
    // hit alt-Insert (in Windows machines)

    private String firstName;
    private String lastName;
    private int zipCode;

    public SettersGetters(String firstName, String lastName, int zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
