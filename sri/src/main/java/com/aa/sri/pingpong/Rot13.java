package com.aa.sri.pingpong;

public class Rot13 {

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
        if ((char)(arg)=='Z'){
            return String.valueOf( (char) (arg-25));
        }
        return String.valueOf((char)(arg+1));
//        return String.valueOf(
//                (char) (arg + ((arg >= 'N') ? -13 : 13))
//        );
    }

    private static void guardEncode(char arg) {
        if (arg < 'A' || arg > 'Z') {
            throw new IllegalArgumentException();
        }
    }

    public static Exception example() {
        return new IllegalArgumentException();
    }
}
