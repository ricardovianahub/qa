package com.aa.sri.fundamentals.oop.composition;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompositionTest {

    // Composition is created when an object contains an instance of another object
    // and they collaborate together, but one does not *own* the other the way that
    // Superclasses and subclasses do
    // This relationship is not based on "IS A", it's based on "HAS A"

    @Test
    void carTest() {
        // setup
        Car car = new Car();
        Passenger passenger1 = new Passenger("John", "Doe");
        Passenger passenger2 = new Passenger("Jane", "Doe");

        car.addPassenger(passenger1);
        car.addPassenger(passenger2);

        // execution
        int actual = car.numberOfPassengers();

        // assertion
        assertEquals(2, actual);
    }

    @Test
    void carTestPassengersLeave() {
        BadCar car = new BadCar();
        car.addPassenger(new BadPassenger("John", "Doe"));
        car.addPassenger(new BadPassenger("Jane", "Doe"));

        // executions
        car.removePassenger("John", "Doe");

        // assertion
        assertEquals(1, car.numberOfPassengers());
    }

    @Test
    void printableExample() {

        // Inheritance: decision at compile time
        BadPassenger badPassenger1 = new BadPassenger("One", "Smith");
        BadPassenger badPassenger2 = new BadPassenger("Two", "Smith");

        // Composition: decision at compile time OR runtime
        Car car = new Car();
        car.addPassenger(new Passenger("One", "Jones"));
        car.addPassenger(new Passenger("Two", "Jones"));

        System.out.println(badPassenger1);
        System.out.println(badPassenger2);

        System.out.println(car);

        car.addPassenger(new Passenger("Three", "Jones"));
        car.removePassenger("Two", "Jones");

        System.out.println(car);
    }

    private class BadCar {
        private int numberOfPassengers = 0;

        public void addPassenger(BadPassenger passenger) {
            this.numberOfPassengers++;
        }

        public int numberOfPassengers() {
            return this.numberOfPassengers;
        }

        public void removePassenger(String first, String last) {
            this.numberOfPassengers--;
        }

    }
    private class BadPassenger extends BadCar {

        public BadPassenger(String first, String last) {

        }
    }

}
