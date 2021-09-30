package com.aa.sri.pingpong;

public class Slide2 extends CharacterEncoder {

    @Override
    String checkEachCharacter(String argument) {
        char arg = argument.charAt(0);
        guardEncode(arg);
        return String.valueOf(
                (char) (arg + ((arg == 'A') ? +25 : -1))
        );
    }

}
