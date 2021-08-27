package com.aa.workshop;

public class T0019SubClass extends T0019SuperClass { // extends means "it's a child of"
    @Override
    public String name() {
        return super.name() + " That person's name is Doe. Jennifer Doe.";
    }

    public String onlySubClass() {
        return "I'm only available in the subclass";
    }
}
