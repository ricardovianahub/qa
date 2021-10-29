package com.aa.sri.pingpong.pp008;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Romans {
    Map<Integer, String> romanNumerals = new LinkedHashMap<>() {{
        put(1000, "M");
        put(500, "D");
        put(100, "C");
        put(50, "L");
        put(10, "X");
        put(5, "V");
        put(1, "I");
    }};

    public String convert(int argument) {
        String result;
        result = repeatedLetters(argument, 1, 3);
        if (result != null) {
            return result;
        }
        result = repeatedLetters(argument, 10, 30);
        if (result != null) {
            return result;
        }
        result = repeatedLetters(argument, 100, 300);
        if (result != null) {
            return result;
        }
        result = repeatedLetters(argument, 1000, 3000);
        if (result != null) {
            return result;
        }
        if (argument == 6||argument == 11) {
            StringBuilder sb = new StringBuilder();
            System.out.println(romanNumerals.entrySet().toString());
            for(Map.Entry<Integer,String> entry: romanNumerals.entrySet()){
                if(entry.getKey()<= argument){
                    sb.append(entry.getValue());

                }
            }
            return sb.toString();
        }
        return romanNumerals.get(argument);
    }

    private String repeatedLetters(int argument, int lowerRange, int higherRange) {
        if (argument >= lowerRange && argument <= higherRange) {
            return romanNumerals.get(lowerRange).repeat(argument / lowerRange);
        }
        return null;
    }
}
