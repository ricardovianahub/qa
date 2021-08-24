package com.aa.sri.fundamentals.oop;

public class Encapsulation {

    // Scope keywords apply to both variables and methods

    public String publicVar = "I'm public"; // anywhere
    protected String protectedVar = "I'm protected"; // same package or subclasses
    String var = "I'm default"; // "Default" only same package
    private String privateVar = "I'm private"; // Only inside the same class

}
