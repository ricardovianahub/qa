package com.aa.sri.pingpong;

public class Rot13 extends CharacterEncoder {

    @Override
    String checkEachCharacter(String argument) {
        char arg = argument.charAt(0);
        guardEncode(arg);
        return String.valueOf(
                (char) (arg + ((arg >= 'N') ? -13 : 13))
        );
    }

    public Exception example() {
        return new IllegalArgumentException();
    }
}
