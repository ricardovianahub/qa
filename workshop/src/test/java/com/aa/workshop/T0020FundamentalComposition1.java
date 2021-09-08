package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class T0020FundamentalComposition1 {

    @Test
    void chefWithKnife() {
        Chef chef = new Chef("Jim", "Bean");
        Tool tool = new Knife();
        chef.hold(tool);
        assertEquals("cut", tool.action());
        assertEquals("cut", chef.action());
    }

    @Test
    void chefWithPan() {
        Chef chef = new Chef("Laura", "Bean");
        Tool tool = new Pan();
        chef.hold(tool);
        assertEquals("sautee", tool.action());
        assertEquals("sautee", chef.action());
        Tool anotherTool = new Knife();
        chef.hold(anotherTool);
        assertEquals("cut", chef.action());
    }

    @Test
    void conducting() {
        Conductor conductor = new Conductor();

        Instrument violin = new Violin();
        Instrument trumpet = new Trumpet();
        Instrument timpani = new Timpani();

        conductor.orchestrates(violin);
        conductor.orchestrates(trumpet);
        conductor.orchestrates(timpani);

        List<String> sounds;
        sounds = conductor.play();

        assertEquals(3, sounds.size());
        assertTrue(sounds.contains("Violin plays"), "Violins are not playing");
        assertTrue(sounds.contains("Trumpet plays"), "Trumpets are not playing");
        assertTrue(sounds.contains("Timpani plays"), "Timpani are not playing");
    }

    @Test
    void conductingFewerInstruments() {
        Conductor conductor = new Conductor();

        Instrument violin = new Violin();
        Instrument trumpet = new Trumpet();

        conductor.orchestrates(violin);
        conductor.orchestrates(trumpet);

        List<String> sounds;
        sounds = conductor.play();

        assertEquals(2, sounds.size());
        assertTrue(sounds.contains("Violin plays"), "Violins are not playing");
        assertTrue(sounds.contains("Trumpet plays"), "Trumpets are not playing");
    }

    // Challenge
    // Create a Farm object. The Farm contains/holds/has animals
    // Animals will be; Chicken, Cow, Dog
    // Chicken lays eggs; Cow gives milk; Dog barks
    // Assign/add your animal objects to your farm object
    // Ask your farm object to "operate". Check if animals did what they do

}
