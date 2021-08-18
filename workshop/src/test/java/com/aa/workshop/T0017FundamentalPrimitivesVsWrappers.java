package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class T0017FundamentalPrimitivesVsWrappers {

    @Test
    void multipleTypes() {
        // Boolean is an exception, both boolean and Boolean behave the same, unlike all of the other primitive/wrapper pairs
        Boolean wrapperBoolean = Boolean.TRUE;  // TRUE FALSE NULL
        boolean primitiveBoolean = true;        // TRUE FALSE

        Integer wrapperInteger = new Integer(737);
        int primitiveInteger = 737;

        Float wrapperFloat = new Float(4234.5);
        float primitiveFloat = 4234.5f;

        assertSame(wrapperBoolean, primitiveBoolean);
        assertEquals(wrapperInteger, primitiveInteger); // .equals() not ==
        assertEquals(wrapperFloat, primitiveFloat);
    }

    // object1.equals(object2)        ----> compare values, which is what you want 99% of the times
    // object1 == object2             ----> compare memory addresses, which you almost never need to do in a business scenario
    // primitive1 == primitive 2      ----> compare values
    // primitive1.equals(primitive 2) ----> easy to avoid because IT DOES NOT COMPILE

    // Stack                                           - HEAP
    // Boolean wrapperBoolear   [001000]               - [001000] TRUE
    // boolean primitiveBoolean [000001]               - N/A
    // Integer wrapperInteger   [002000]               - [002000] 737
    // Integer example          [003000]               - [003000] 737
    // int primitiveInteger     [000737]               - N/A
    // Boolean nowhere []                              - N/A

    // The word "equal" really means "carries equal value"
    // assertEquals is equivalent to .equals - compare values   <======= Always do THIS
    // assertSame is equivalent to == - compare the addresses of the varilables

    // Integer b1 = 737;  // stack -> Integer b1 [001000] // heap -> [001000] 737
    // Integer b2 = 737;  // stack -> Integer b2 [002000] // heap -> [002000] 737 ==> EQUAL TO B1, SAME AS B3
    // Integer b3 = b2;   // stack -> Integer b3 [002000]  ===> SAME AS B2
    // When you compare primitives it's always ==
    // When you compare objects use .equals() - 99% of the times
}
