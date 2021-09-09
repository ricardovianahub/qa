package com.aa.sri.fundamentals.oop.composition3;

public class Chef {
    //         HAS A
    private Instrument instrument;

    public void hold(Instrument instrument) {
        this.instrument = instrument;
    }

    public String action() {
        return instrument.action();
    }
}
