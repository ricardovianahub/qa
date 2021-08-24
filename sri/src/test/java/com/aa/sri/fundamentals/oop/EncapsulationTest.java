package com.aa.sri.fundamentals.oop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;

import org.junit.jupiter.api.Test;

public class EncapsulationTest {

    @Test
    void assertScopes() throws NoSuchFieldException, IllegalAccessException {
        Encapsulation encapsulation = new Encapsulation();

        Field publicVarField = Encapsulation.class.getField("publicVar");
        Field protectedVarField = Encapsulation.class.getDeclaredField("protectedVar");
        Field varField = Encapsulation.class.getDeclaredField("var");
        Field privateVarField = Encapsulation.class.getDeclaredField("privateVar");
        privateVarField.setAccessible(true);

        assertEquals("I'm public", publicVarField.get(encapsulation));
        assertEquals("I'm protected", protectedVarField.get(encapsulation));
        assertEquals("I'm default", varField.get(encapsulation));
        assertEquals("I'm private", privateVarField.get(encapsulation));
    }

}
