package com.aa.sri.pingpong.pp008;

import java.util.HashMap;
import java.util.Map;

public class Romans {
    Map<Integer, String> romanNumerals = new HashMap<>() {{
        put(1,"I");
        put(5,"V");
        put(10,"X");
        put(50,"L");
        put(100,"C");
        put(500,"D");
        put(1000,"M");
    }};

    public String convert(int argument) {
        if (argument == 2) {
            return "II";
        }
        return romanNumerals.get(argument);
    }
}
