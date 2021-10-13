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

        if (word.length() > 2) {
            return longerAnagram(word);
        }

//        if ("def".equals(word)) {
//            return new String[]{"def", "dfe", "edf", "efd", "fde", "fed"};
//        }

        String[] strings = createAnagramizedList(
                word.chars()                                      // "h", "e", "l", "l", "o"  --- actually 104, 65, 108, 108, 111
                        .sorted()                                 // "e", "h", "l", "l", "o"  --- actually 65, 104, 108, 108, 111
                        .mapToObj(c -> String.valueOf((char) c))  // "e", "h", "l", "l", "o"
                        .collect(Collectors.joining())            // "ehllo"
        ).toArray(String[]::new);
        return strings;
    }

    private String[] longerAnagram(String word) {
        List<StringBuilder> results = new ArrayList<>();
        for (byte b : word.getBytes()) {
            results.add(new StringBuilder("" + (char) b));
            results.add(new StringBuilder("" + (char) b));
        }
        for (byte b : word.getBytes()) {
            for (StringBuilder result : results) {
                if (!result.toString().contains("" + (char) b)) {
                    result.append("" + (char) b);
                }
            }
        }
        for (byte b : word.getBytes()) {
            for (StringBuilder result : results) {
                if (!result.toString().contains("" + (char) b)) {
                    result.append("" + (char) b);
                }
            }
        }
        List<String> output = new ArrayList<>();
        results.forEach(stringBuilder -> output.add(stringBuilder.toString()));
        return output.toArray(new String[]{});
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
            tempWord = lastLetter(tempWord) + everythingExceptLastLetter(tempWord);
        }
        // def = d(0) e(1) f(2) -- f  // d ef // def dfe edf efd fde fed
        // "ab".substring(0,1) does not mean "ab", it means "a" because 1 is the first position
        // NOT to be included
        // "abc".substring(1) => "bc"
        return result;
    }

    private String everythingExceptLastLetter(String tempWord) {
        return tempWord.substring(0, tempWord.length() - 1);
    }

    private String lastLetter(String word) {
        return word.substring(word.length() - 1);
    }

    private String anagramize(String s) {
        return s;
    }

}

// 2 ways to solve a data problem:
// 1 - Create a solution which is incomplete, then keep changing it until it's correct
//  def - (d)(ef) --- efd - (e)(fd) -- fde (f)(de)
// 2 - Make it right from the beginning (could be more complex to code)


// Create a copy of the letters = "def"
// Run a loop for the first letter of the result. Populate it with all 3 possible letters  of the input
// Run a loop for the second letter of the result. Populate it with all letters in the input that are not contained in the result
// Run a loop for the third letter of the result. Populate it with all letters in the input that are not contained in the result

// Input: DEF --- "working are" E - Output: D
//
