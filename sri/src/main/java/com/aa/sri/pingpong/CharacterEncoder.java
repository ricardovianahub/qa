package com.aa.sri.pingpong;

public abstract class CharacterEncoder {

    public String encode(String argument) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < argument.length(); i++) {
            sb.append(checkEachCharacter(argument.substring(i)));
        }
        return sb.toString();
    }

    abstract String checkEachCharacter(String argument);

    public void guardEncode(char arg) {
        if (arg < 'A' || arg > 'Z') {
            throw new IllegalArgumentException();
        }
    }

}
