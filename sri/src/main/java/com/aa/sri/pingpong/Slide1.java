package com.aa.sri.pingpong;

public class Slide1 {

    public static String encode(String argument) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < argument.length(); i++) {
            sb.append(checkEachCharacter(argument.substring(i)));
        }
        return sb.toString();
    }

    private static String checkEachCharacter(String argument) {
        char arg = argument.charAt(0);
        guardEncode(arg);
        return String.valueOf(
                (char) (arg+ ((arg=='Z')?-25:1))
        );
    }

    private static void guardEncode(char arg) {
        if (arg < 'A' || arg > 'Z') {
            throw new IllegalArgumentException();
        }
    }

}
