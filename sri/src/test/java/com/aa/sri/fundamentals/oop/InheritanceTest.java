package com.aa.sri.fundamentals.oop;

import org.junit.jupiter.api.Test;

public class InheritanceTest {

    @Test
    void innerClass() {
        System.out.println("-----------------------------------------");
        printAbout(new HondaCivic());
        System.out.println("-----------------------------------------");
        printAbout(new ToyotaPrius());
        System.out.println("-----------------------------------------");
        printAbout(new ToyotaYaris());
        System.out.println("-----------------------------------------");
    }

    private void printAbout(Vehicle vehicle) {
        System.out.println("Model = " + vehicle.model());
        System.out.println("Mileage = " + vehicle.mileage());
        System.out.println("Has AC = " + vehicle.hasAC());
        System.out.println("Color = " + vehicle.color());
    }

    private abstract class Vehicle {
        public float mileage() {
            return 0;
        }

        public boolean hasAC() {
            return false;
        }

        public String color() {
            return null;
        }

        public String model() {
            return "Model name is ";
        }
    }

    private class HondaCivic extends Vehicle { // public + protected
        @Override
        public String model() {
            return super.model() + "Civic";
        }

    }

    private class ToyotaPrius extends Vehicle {
        @Override
        public String model() {
            return super.model() + "Prius";
        }

        @Override
        public float mileage() {
            return 45.6f;
        }
    }

    private class ToyotaYaris extends ToyotaPrius {
        @Override
        public String model() {
            return super.model() + " - Yaris";
        }
    }
}

// Rule:
// Inheritance: 2 objects should only be related via inheritance
//              if you can say "is a" to their relationship
//              For example: Civic "is a" Vehicle

