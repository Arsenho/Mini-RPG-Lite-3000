package com.isep.rpg;

import java.util.List;

public abstract class Hero {
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected List<Potion> potions;
    protected List<Food> lembas;

    public void defend(){}
    public void useConsumable(Consumable consumable){}

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public boolean isDead(){
        return this.lifePoints <= 0;
    }

    public void addArmor(int quantity){
        this.armor += quantity;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
