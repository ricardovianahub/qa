package com.aa.sri.fundamentals.oop.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class StreamsTest {

    @Test
    void streamTest() {

        List<String> strings = Arrays.asList("One", "Two", "Three", "Four", "Five");

        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println(strings.stream().filter((string) -> string.startsWith("T")).collect(Collectors.joining()));
        System.out.println(
                strings.stream().anyMatch("Two"::equals)
        );

    }

}
