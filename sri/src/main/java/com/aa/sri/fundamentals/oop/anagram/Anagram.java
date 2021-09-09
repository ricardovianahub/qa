package com.aa.sri.fundamentals.oop.anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// The name "Controller" comes from the "Gang of 4" Design Patterns book
// It means an orchestrator, as class that only calls other classes
// but doesn't have any specific business logic of its own
public class Anagram {
    public enum STRATEGY {ALL}

    public Anagram(STRATEGY strategy) {

    }

    public String[] buildAnagrams(String word) {
        // Guard statement
        if (word == null || "".equals(word)) {
            return new String[]{""};
        }

//        if ("def".equals(word)) {
//            return new String[]{"def", "dfe", "edf", "efd", "fde", "fed"};
//        }

        return createAnagramizedList(
                word.chars().sorted().mapToObj(c -> "" + (char) c)
                        .collect(Collectors.joining())
        ).toArray(String[]::new);
    }

    private List<String> createAnagramizedList(String word) {
        List<String> result = new ArrayList<>();

        String tempWord = word;

        for (int i = 0; i < word.length(); i++) {
            result.add(
                    anagramize(
                            tempWord
                    )
            );
            tempWord = tempWord.substring(tempWord.length() - 1)
                    + tempWord.substring(0, tempWord.length() - 1);
        }
        // def = d(0) e(1) f(2) -- f  // d ef // def dfe edf efd fde fed
        // "ab".substring(0,1) does not mean "ab", it means "a" because 1 is the first position
        // NOT to be included
        // "abc".substring(1) => "bc"

        return result;
    }

    private String anagramize(String s) {
        return s;
    }

}

// 2 ways to solve a data problem:
// 1 - Create a solution which is incomplete, then keep changing it until it's correct
//  def - (d)(ef) --- efd - (e)(fd) -- fde (f)(de)
// 2 - Make it right from the beginning (could be more complex to code)
