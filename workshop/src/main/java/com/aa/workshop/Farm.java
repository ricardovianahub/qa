package com.aa.workshop;

import java.util.ArrayList;
import java.util.List;

public class Farm {

    private final List<Tractor> tractors = new ArrayList<>();


    public void tractors(Tractor tractor) { this.tractors.add(tractor); }



    public List<String> action() {
        List<String> result = new ArrayList<>();
        for (Tractor tractor : tractors) {
            result.add(tractor.action());
        }
        return result;
    }
}