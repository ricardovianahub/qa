package com.aa.workshop;

import java.util.ArrayList;
import java.util.List;

public class Conductor {
    //                 HAS
    private final List<Instrument> instruments = new ArrayList<>();

    public void orchestrates(Instrument instrument) {
        this.instruments.add(instrument);
    }

    public List<String> play() {
        List<String> result = new ArrayList<>();
        for (Instrument instrument : instruments) {
            result.add(instrument.play());
        }
        return result;
    }
}
