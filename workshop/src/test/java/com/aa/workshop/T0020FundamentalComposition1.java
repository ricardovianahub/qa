package com.aa.workshop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.checkerframework.checker.units.qual.K;
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

}
