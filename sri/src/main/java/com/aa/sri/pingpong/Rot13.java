package com.aa.sri.pingpong;

public class Rot13 {

    public static String encode(String argument) throws IllegalArgumentException {
        guardEncode(argument);
        if (argument.charAt(0) >= 65 && argument.charAt(0) <= 77) {
            return String.valueOf((char) (argument.charAt(0) + 13));
        }
        if (argument.charAt(0) >= 78 && argument.charAt(0) <= 90) {
            return String.valueOf((char) (argument.charAt(0) - 13));
        }
return null;
}

    private static void guardEncode(String argument) {
        if ("%".equals(argument)) {
            throw new IllegalArgumentException();
        }
    }
}
