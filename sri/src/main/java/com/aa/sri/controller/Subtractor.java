package com.aa.sri.controller;

import org.springframework.stereotype.Component;

@Component
public class Subtractor {
    public int subtract(int first, int second) {
        return first - second;
    }
}
