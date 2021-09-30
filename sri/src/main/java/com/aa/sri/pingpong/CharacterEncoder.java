package com.aa.sri.pingpong;

public abstract class CharacterEncoder {

    public String encode(String argument) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < argument.length(); i++) {
            sb.append(checkEachCharacter(argument.substring(i)));
        }
        return sb.toString();
    }

    public void guardEncode(char arg) {
        if (arg < 'A' || arg > 'Z') {
            throw new IllegalArgumentException();
        }
    }

    protected interface EncodingCondition {
        boolean test(char arg);
    }

    String checkEachCharacter(String argument) {
        char arg = argument.charAt(0);
        guardEncode(arg);
        return String.valueOf(
                (char) (arg + (encodingCondition().test(arg) ? trueResult() : falseResult()))
        );
    }

    abstract EncodingCondition encodingCondition();
    abstract int trueResult();
    abstract int falseResult();

}
