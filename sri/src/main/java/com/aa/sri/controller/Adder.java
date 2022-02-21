package com.aa.sri.controller;

import org.springframework.stereotype.Component;

@Component
public class Adder {
    public int add(int first, int second) {
        return first + second;
    }
}
