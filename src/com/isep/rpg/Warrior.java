package com.isep.rpg;

import java.util.ArrayList;

public class Warrior extends Hero{
    public Warrior(){
        this.setLifePoints(0);
        this.setArmor(0);
        this.setWeaponDamage(0);
        potions = new ArrayList<>();
        lembas = new ArrayList<>();
    }

    public Warrior(int lifePoints, int armor, int weaponDamage) {
        super(lifePoints, armor, weaponDamage);
        System.out.println("create new warrior with life Points = " +this.lifePoints + " armor = " +this.armor + " weaponDamage = " + this.weaponDamage);
    }
}
