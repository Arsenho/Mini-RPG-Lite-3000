package com.isep.rpg;

import java.util.ArrayList;

public class Hunter extends Hero{
    protected int arrows;

    public Hunter(){
        this.setLifePoints(0);
        this.setArmor(0);
        this.setWeaponDamage(0);
        this.setArrows(0);

        potions = new ArrayList<>();
        lembas = new ArrayList<>();
    }

    public Hunter(int arrows){
        this.arrows = arrows;
    }

    public void shutArrow() {
        this.arrows -= 1;
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
