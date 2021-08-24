package com.aa.sri.fundamentals.oop.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The name "Controller" comes from the "Gang of 4" Design Patterns book
// It means an orchestrator, as class that only calls other classes
// but doesn't have any specific business logic of its own
public class Example1 {
    public enum STRATEGY {ALL}

    public Example1(STRATEGY strategy) {

    }

    public String[] buildAnagrams(String word) {
        if (word == null || "".equals(word)) {
            return new String[]{""};
        }
        if ("def".equals(word)) {
            return new String[]{"def", "dfe", "edf", "efd", "fde", "fed"};
        }
        if ("ab".equals(word)) {
            return new String[]{"ab", "ba"};
        }
        return createAnagramizedList(
                word.chars().sorted().mapToObj(c -> "" + (char) c)
                        .collect(Collectors.joining())
        ).toArray(String[]::new);
    }

    private List<String> createAnagramizedList(String word) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            result.add(
                    anagramize(
                            word.substring(word.length() - i - 1) +
                                    word.substring(i, i + word.length() - i - 1)
                    )
            );
        }

        return result;
    }

    private String anagramize(String s) {
        return s;
    }

}
