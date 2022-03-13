package com.isep.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HunterTest {
    @Test
    public void testArrowsDecrease(){
        Hunter hunter = new Hunter(45);
        hunter.shutArrow();
        assertEquals(44, hunter.getArrows());
    }
}
