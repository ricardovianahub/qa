package com.aa.sri.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    List<String> values = new ArrayList<>();

    public void push(String text) {
        values.add(text);
    }

    public int size() {
        return values.size();
    }

    public String pop() {
        String result = values.get(values.size() - 1);
        values.remove(values.size() - 1);
        return result;
    }
}
