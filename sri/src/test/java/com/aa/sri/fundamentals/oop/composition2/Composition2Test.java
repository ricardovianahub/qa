package com.aa.sri.fundamentals.oop.composition2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Composition2Test {

    @Test
    void currencyConversion() {
        Dollar dollar = new Dollar();
        CurrencyConversion canadianDollar =
                CurrencyConversion.byCurrency(
                        CurrencyConversion.Currency.CANADIAN_DOLLAR
                );

        dollar.setValue(100);
        dollar.setCurrencyConversion(canadianDollar);

        assertEquals(110, dollar.convertedValue());

        // same dollar object, now with a different currency conversion attribute

        CurrencyConversion brazilianReal =
                CurrencyConversion.byCurrency(
                        CurrencyConversion.Currency.BRAZILIAN_REAL
                );

        dollar.setCurrencyConversion(brazilianReal);

        assertEquals(505, dollar.convertedValue(), 0.0001);
    }

}
