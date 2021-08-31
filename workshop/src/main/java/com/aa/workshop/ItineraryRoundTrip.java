package com.aa.workshop;

public class ItineraryRoundTrip extends Itinerary {
    @Override
    public String description() {
        return "Round trip" + super.veryComplicatedFeature();
    }
}
