package com.aa.sri.fundamentals.oop.composition;

import java.util.Objects;

public class Passenger {
    private final String first;
    private final String last;

    public Passenger(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return Objects.equals(first, passenger.first) && Objects.equals(last, passenger.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
}
