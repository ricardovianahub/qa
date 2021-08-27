package com.aa.workshop;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class T0019FundamentalInheritanceSuperSub {

    @Test
    void superAndSubclasses() {
        T0019SuperClass t0019SuperClass = new T0019SuperClass();

        System.out.println(t0019SuperClass.info());
        System.out.println(t0019SuperClass.name());

        System.out.println("------------------------------------");

        T0019SuperClass t0019SubClass = new T0019SubClass();

        System.out.println(t0019SubClass.info());
        System.out.println(t0019SubClass.name());

        System.out.println("------------------------------------");

        T0019SubClass t0019SubClassOnly = new T0019SubClass();

        System.out.println(t0019SubClassOnly.info());
        System.out.println(t0019SubClassOnly.name());
        System.out.println(t0019SubClassOnly.onlySubClass());

        System.out.println("------------------------------------");

        Itinerary itineraryOneWay = new ItineraryOneWay();
        Itinerary itineraryRoundTrip = new ItineraryRoundTrip();
        Itinerary itineraryMultiCity = new ItineraryMultiCity();

        List<Itinerary> itineraries = new ArrayList<>();

        itineraries.add(itineraryOneWay);
        itineraries.add(itineraryRoundTrip);
        itineraries.add(itineraryMultiCity);

        for (Itinerary itin : itineraries) {
            System.out.println(itin.type());
        }

    }

    // When?
    // The rule is: when you can say the subclass/child class IS A superclass/parent class
    // For example: ItineraryOneWay IS A Itinerary
    // Or: Honda Civic IS A Vehicle
    // Or: Dog IS AN animal
    // Not applicable, for example:
    // PERSON and NAME, because a PERSON IS NOT A NAME, A NAME IS NOT A PERSON

    // Challenge:
    // Create a group of classes that will represent this:
    // Animals cal "speak"
    // When a dog "speaks" it should say "woof"
    // When a cat "speaks" it should say "meow"
    // When a cow "speaks" it should say "moo"
    // Create a list of animals
    // Loop through them, and ask each of them to "speak"
}
