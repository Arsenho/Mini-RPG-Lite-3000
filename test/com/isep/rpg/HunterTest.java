package com.isep.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HunterTest {
    @Test
    public void testArrowsDecrease(){
        int lifePoints = 45;
        int armor = 45;
        int weaponDamage = 45;
        Hunter hunter = new Hunter(lifePoints, armor, weaponDamage);
        hunter.attack(Attack.arrow);
        assertEquals(44, hunter.getArrows());
    }
}
