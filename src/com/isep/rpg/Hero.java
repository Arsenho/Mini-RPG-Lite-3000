package com.isep.rpg;

import java.util.List;

public abstract class Hero {
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected List<Potion> potions;
    protected List<Food> lembas;

    public Hero(){}
    public void defend(){}
    public void useConsumable(Consumable consumable){}


}
