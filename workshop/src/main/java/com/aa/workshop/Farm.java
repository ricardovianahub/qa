package com.aa.workshop;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private final List<Tractor> tractor = new ArrayList<>();

    public void tractor(Tractor tractor) { this.tractor.add(tractor); }

    public List<String> action() {
        List<String> result = new ArrayList<>();
        for (Tractor tractor : tractor){
            result.add(tractor.action());
        }
        return result;
    }

    public void tractors(Tractor kubota) {
    }
}
