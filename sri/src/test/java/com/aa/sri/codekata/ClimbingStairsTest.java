package com.aa.sri.codekata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ClimbingStairsTest {

    @Test
    void climbingStairsReturnsTwoWhenTwoIsPassedIn() {
        ClimbingStairs climbing = new ClimbingStairs();
        assertEquals(2, climbing.climbStairs(2));

    }

    @Test
    void climbingStairsReturnsThreeWhenThreeIsPassedIn() {
        ClimbingStairs climbing = new ClimbingStairs();
        assertEquals(3, climbing.climbStairs(3));
    }

    @Test
    void climbingStairsReturnsFiveWhenFourIsPassedIn() {
        ClimbingStairs climbing = new ClimbingStairs();
        assertEquals(5, climbing.climbStairs(4));
    }

    @Test
    void climbingStairsReturnsEightWhenFiveIsPassedIn() {
        ClimbingStairs climbing = new ClimbingStairs();
        assertEquals(8, climbing.climbStairs(5));
    }
}
