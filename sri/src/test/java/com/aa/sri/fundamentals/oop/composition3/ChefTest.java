package com.aa.sri.fundamentals.oop.composition3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ChefTest {

    static Stream<Arguments> holdAKitchenInstrumentData() {
        return Stream.of(
            Arguments.of(
                    Knife.class, "cut"
            ),
            Arguments.of(
                    Pan.class, "boil"
            )
        );
    }

    @ParameterizedTest
    @MethodSource("holdAKitchenInstrumentData")
    void holdAKitchenInstrument(Class clazz, String expected) throws InstantiationException, IllegalAccessException {
        Chef chef = new Chef();
        Instrument instrument = (Instrument) clazz.newInstance();

        chef.hold(instrument);

        assertEquals(expected, chef.action());
    }

}
