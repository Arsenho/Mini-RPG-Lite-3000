package com.isep.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HealerTest {

    @Test
    public void testCanOrdinarySpellCast(){
        Healer healer = new Healer();
        healer.setManaPoints(50);
        assertTrue(healer.canCastSpell("ORDINARY"));
    }

    @Test
    public void testCanSuperSpellCast(){
        Healer healer = new Healer();
        healer.setManaPoints(50);
        assertTrue(healer.canCastSpell("SUPER"));
    }

    @Test
    public void testOrdinarySpellCast(){
        Healer healer = new Healer();
        healer.setManaPoints(50);
        healer.castSpell("ORDINARY");
        assertEquals(45, healer.getManaPoints());
    }

    @Test
    public void testSuperSpellCast(){
        Healer healer = new Healer();
        healer.setManaPoints(50);
        healer.castSpell("SUPER");
        assertEquals(40, healer.getManaPoints());
    }
}
