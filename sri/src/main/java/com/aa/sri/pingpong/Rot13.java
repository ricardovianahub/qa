package com.aa.sri.pingpong;

public class Rot13 {

    public static String encode(String argument) throws IllegalArgumentException {
        guardEncode(argument);
        return String.valueOf((char) (argument.charAt(0) + 13));
    }

    private static void guardEncode(String argument) {
        if ("%".equals(argument)) {
            throw new IllegalArgumentException();
        }
    }
}
