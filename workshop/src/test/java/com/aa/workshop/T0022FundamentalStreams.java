package com.aa.workshop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class T0022FundamentalStreams {

    @Test
    void listStream() {
        List<String> strings = Arrays.asList("One", "Two", "Three", "Four", "Five");

        for (String string : strings) {
            System.out.println(string);
        }

        System.out.println(
                strings.stream()
                        .filter((string) -> string.startsWith("F"))
                        .collect(Collectors.joining())
        );

    }

}
