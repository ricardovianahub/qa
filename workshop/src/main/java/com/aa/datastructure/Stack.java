package com.aa.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    int size = 0;
    List<String> values = new ArrayList<>();

    public void push(String value) {
        this.values.add(value);
        size++;
    }

    public int size() {
        return size;
    }

    public String pop() {
        size--;
        String result = this.values.get(this.values.size() - 1);
        this.values.remove(this.values.size() - 1);
        return result;
    }
}
