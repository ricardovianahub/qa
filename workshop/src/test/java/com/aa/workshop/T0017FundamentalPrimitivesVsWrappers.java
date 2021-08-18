package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

public class T0017FundamentalPrimitivesVsWrappers {

    @Test
    void multipleTypes() {
        Boolean wrapperBoolean = Boolean.TRUE;
        boolean primitiveBoolean = true;

        Integer wrapperInteger = new Integer(737);
        int primitiveInteger = 737;

        Float wrapperFloat = new Float(4234.5);
        float primitiveFloat = 4234.5f;

        assertSame(wrapperBoolean, primitiveBoolean);
        assertEquals(wrapperInteger, primitiveInteger);
        assertEquals(wrapperFloat, primitiveFloat);
    }

    // Stack                                           - HEAP
    // Boolean wrapperBoolear [001000]                 - [001000] TRUE
    // boolean primitiveBoolean [000001]               - N/A
    // Integer wrapperInteger [002000]                 - [002000] 737
    // int primitiveInteger [000737]
    // Boolean nowhere []                              - N/A
    //

    // The word "equal" really means "carries equal value"
    // assertEquals is equivalent to .equals - compare values   <======= Always do THIS
    // assertSame is equivalent to == - compare the addresses of the varilables

}
