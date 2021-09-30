package com.aa.sri.pingpong;

import java.util.function.Predicate;

public class Rot13 extends CharacterEncoder {

    @Override
    EncodingCondition encodingCondition() {
        return new EncodingCondition() {
            @Override
            public boolean test(char arg) {
                return (arg >= 'N');
            }
        };
    }

    @Override
    int trueResult() {
        return -13;
    }

    @Override
    int falseResult() {
        return 13;
    }

    public Exception example() {
        return new IllegalArgumentException();
    }
}
