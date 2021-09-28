package com.aa.sri.pingpong;

public class Slide1 extends CharacterEncoder {

    @Override
    String checkEachCharacter(String argument) {
        char arg = argument.charAt(0);
        guardEncode(arg);
        return String.valueOf(
                (char) (arg+ ((arg=='Z')?-25:1))
        );
    }

}
