package com.aa.sri.fundamentals.oop.composition2;

public class Dollar {
    private float value;
    private CurrencyConversion conversion;

    public void setValue(float value) {
        this.value = value;
    }

    public void setCurrencyConversion(CurrencyConversion conversion) {
        this.conversion = conversion;
    }

    public float convertedValue() {
        return this.value * this.conversion.rate();
    }
}
