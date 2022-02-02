package com.aa.sri.autowire;

import org.springframework.stereotype.Component;

@Component
public class Name {
    private String first;
    private String last;

    public Name() {
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
