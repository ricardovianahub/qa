package com.aa.sri.fundamentals.oop.composition;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private List<Passenger> passengers = new ArrayList<>();
    private int numberOfPassengers = 0;

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public int numberOfPassengers() {
        return this.passengers.size();
    }

    public void removePassenger(String first, String last) {
        this.passengers.remove(new Passenger(first, last));
    }

    @Override
    public String toString() {
        return "Car{" +
                "passengers=" + passengers +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }
}
