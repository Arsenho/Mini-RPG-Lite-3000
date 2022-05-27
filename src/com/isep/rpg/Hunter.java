package com.isep.rpg;

import java.util.ArrayList;
import java.util.Random;

public class Hunter extends Hero{
    private int arrows;

    public Hunter(){
        this.setLifePoints(0);
        this.setArmor(0);
        this.setWeaponDamage(0);

        potions = new ArrayList<>();
        lembas = new ArrayList<>();
    }

    public Hunter(int lifePoints, int armor, int weaponDamage, int arrows){
        super(lifePoints, armor, weaponDamage);
        this.arrows = arrows;
    }

    public Hunter(int lifePoints, int armor, int weaponDamage){
        super(lifePoints, armor, weaponDamage);
        Random random = new Random();
        this.arrows = random.nextInt(30, 100);
        System.out.println("create new hunter with life Points = " +this.lifePoints + " armor = " +this.armor + " weaponDamage = " + this.weaponDamage + " arrow = " +this.arrows);
    }



    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public void addArrow(int quantity){
        this.arrows += quantity;
    }
}
