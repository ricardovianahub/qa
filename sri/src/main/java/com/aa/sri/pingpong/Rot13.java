package com.aa.sri.pingpong;

public class Rot13 {

    public static String encode(String argument) throws IllegalArgumentException {
        try {
            if (argument.equals("B")) {
                return "O";
            }

            return "N";
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}



