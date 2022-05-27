package com.isep.rpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Hero implements Action{
    protected int lifePoints;
    protected int armor;
    protected int weaponDamage;
    protected List<Potion> potions;
    protected List<Food> lembas;

    public Hero(){

    }

    public Hero(int lifePoints, int armor, int weaponDamage){
        this.potions = new ArrayList<>();
        this.lembas = new ArrayList<>();
        this.lifePoints = lifePoints;
        this.armor = armor;
        this.weaponDamage = weaponDamage;
        this.initConsumable();
    }

    protected void initConsumable(){
        Random random = new Random();
        int numberOfPotion = random.nextInt(30, 100);
        int quantityOfFood = random.nextInt(30, 100);
        int consumableEfficiency = 0;

        for (int i = 0; i < numberOfPotion; i++) {
            consumableEfficiency = random.nextInt(5, 10);
            Potion potion = new Potion(consumableEfficiency);
            this.potions.add(potion);
        }

        for (int i = 0; i < quantityOfFood; i++) {
            consumableEfficiency = random.nextInt(3, 8);
            Food food = new Food(consumableEfficiency);
            this.lembas.add(food);
        }
    }

    public List<Food> getLembas() {
        return lembas;
    }

    public void setLembas(List<Food> lembas) {
        this.lembas = lembas;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public void setPotions(List<Potion> potions) {
        this.potions = potions;
    }

    @Override
    public void defend(Attack attack){
        System.out.println("hero is defending !!! ");
        System.out.println("hero armor before defend ==  " + this.armor);
        switch (attack){
            case enemy -> {
                if (this.armor <= 0) {
                    this.collect(4);
                    return;
                }
                this.armor -= 4;
                break;
            }
        }
        System.out.println("hero armor after defend ==  " + this.armor);
    }

    protected void useConsumable(Consumable consumable){}

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public boolean isDead(){
        return this.lifePoints <= 0;
    }

    public void addArmor(int quantity){
        this.armor += quantity;
    }

    public void addWeaponDamage(int quantity){
        this.weaponDamage += quantity;
    }

    public void addPotion(int quantity){
        int consumableEfficiency = 0;
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            consumableEfficiency = random.nextInt(5, 10);
            Potion potion = new Potion(consumableEfficiency);
            this.potions.add(potion);
        }
    }

    public void addLembas(int quantity){
        int consumableEfficiency = 0;
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            consumableEfficiency = random.nextInt(3, 8);
            Food food = new Food(consumableEfficiency);
            this.lembas.add(food);
        }
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

    @Override
    public Attack attack(Attack attack){
        System.out.println("hero is attacking !!!");
        return attack;
    }

    @Override
    public void collect(int numberOfDamage){
        System.out.println("hero is collecting damage !!! " + numberOfDamage);
        this.lifePoints -= numberOfDamage;
    }

    public void eatLembas(){
        if (lembas.size() == 0) {
            System.out.println("not enough lembas !!! ");
            return;
        }

        Random random = new Random();
        int foodIndex = random.nextInt(0, lembas.size());

        Food food = lembas.get(foodIndex);
        lembas.remove(food);

        this.lifePoints += food.getEfficiency();
        System.out.println("eat some lembas !!!");
    }

    public void drinkPotion(){
        if (potions.size() == 0) {
            System.out.println("not enough potion !!! ");
            return;
        }

        Random random = new Random();
        int potionIndex = random.nextInt(0, potions.size());

        Potion potion = potions.get(potionIndex);
        potions.remove(potion);

        this.lifePoints += potion.getEfficiency();

        System.out.println("drink some potion !!!");
    }
}
