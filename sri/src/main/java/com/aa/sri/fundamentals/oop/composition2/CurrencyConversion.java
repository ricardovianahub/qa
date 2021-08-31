package com.aa.sri.fundamentals.oop.composition2;

public interface CurrencyConversion {
    static CurrencyConversion byCurrency(Currency currency) {
        if (Currency.CANADIAN_DOLLAR.equals(currency)) {
            return new CanadianDollarCurrencyConversion();
        }
        if (Currency.BRAZILIAN_REAL.equals(currency)) {
            return new BrazilianRealCurrencyConversion();
        }
        return () -> 0;
    }

    float rate();

    enum Currency {BRAZILIAN_REAL, CANADIAN_DOLLAR}
}
