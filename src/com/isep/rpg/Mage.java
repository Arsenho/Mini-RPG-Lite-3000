package com.isep.rpg;

import java.util.ArrayList;

public class Mage extends SpellCaster{
    public Mage(){
        this.setLifePoints(0);
        this.setArmor(0);
        this.setWeaponDamage(0);
        potions = new ArrayList<>();
        lembas = new ArrayList<>();
    }
}
