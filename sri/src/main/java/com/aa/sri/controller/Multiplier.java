package com.aa.sri.controller;

import org.springframework.stereotype.Component;

@Component
public class Multiplier {
    public int multiply(int first, int second) {
        return first * second;
    }
}
