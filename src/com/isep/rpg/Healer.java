package com.isep.rpg;

import java.util.ArrayList;

public class Healer extends SpellCaster{
    public Healer(){
        this.setLifePoints(0);
        this.setArmor(0);
        this.setWeaponDamage(0);
        potions = new ArrayList<>();
        lembas = new ArrayList<>();
    }

    public Healer(int lifePoints, int armor, int weaponDamage, int manaPoints) {
        super(lifePoints, armor, weaponDamage, manaPoints);
        System.out.println("create new healer with life Points = " +this.lifePoints + " armor = " +this.armor + " weaponDamage = " + this.weaponDamage + " mana points = " + manaPoints);
    }

    @Override
    public Attack attack(Attack attack) {
        this.canCastSpell("SUPER");
        return super.attack(attack);
    }

}
