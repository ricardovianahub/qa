package com.aa.sri.pingpong;

public class Slide1 extends CharacterEncoder {

    @Override
    EncodingCondition encodingCondition() {
        return new EncodingCondition() {
            @Override
            public boolean test(char arg) {
                return (arg == 'Z');
            }
        };
    }

    @Override
    int trueResult() {
        return -25;
    }

    @Override
    int falseResult() {
        return 1;
    }


}
