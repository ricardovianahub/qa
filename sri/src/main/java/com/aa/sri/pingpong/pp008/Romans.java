package com.aa.sri.pingpong.pp008;

import java.util.HashMap;
import java.util.Map;

public class Romans {
    public String convert(int argument) {
        Map<Integer, String> romanNumerals = new HashMap<>();
        romanNumerals.put(1,"I");
        romanNumerals.put(5,"V");
        romanNumerals.put(10,"X");
        romanNumerals.put(50,"L");
        romanNumerals.put(100,"C");
        romanNumerals.put(500,"D");
        romanNumerals.put(1000,"M");
        if (argument == 5) {
            return romanNumerals.get(5);
        }
        if (argument == 10) {
            return romanNumerals.get(10);
        }
        if (argument == 50) {
            return romanNumerals.get(50);
        }
        if (argument == 100) {
            return romanNumerals.get(100);
        }
        if (argument == 500) {
            return romanNumerals.get(500);
        }
        if (argument == 1000) {
            return romanNumerals.get(1000);
        }
        return romanNumerals.get(1);        
    }
}
