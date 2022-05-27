package com.isep.rpg;

public abstract class Enemy implements Action{
    protected int lifePoints;
    protected int weaponDamage;
    protected int armor;

    public Enemy(){

    }

    public Enemy(int lifePoints, int weaponDamage){
        this.lifePoints = lifePoints;
        this.weaponDamage = weaponDamage;
    }

    @Override
    public boolean isDead() {
        return this.lifePoints <= 0;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void damage(int numberOfDamage) {
        this.lifePoints -= numberOfDamage;
    }

    @Override
    public Attack attack(Attack attack){
        System.out.println("enemy is attacking !!!");
        return attack;
    }

    @Override
    public void defend(Attack attack) {
        System.out.println("enemy is defending !!! ");
        System.out.println("enemy armor before defend ==  " + this.armor);
        switch (attack){
            case arrow -> {
                if (this.armor == 0) {
                    this.collect(5);
                    return;
                }
                this.armor -= 5;
                break;
            }
            case hit -> {
                if (this.armor == 0) {
                    this.collect(10);
                    return;
                }
                this.armor -= 10;
                break;
            }
            case heal -> {
                if (this.armor == 0) {
                    this.collect(8);
                    return;
                }
                this.armor -= 8;
                break;
            }
            case wish -> {
                if (this.armor == 0) {
                    this.collect(15);
                    return;
                }
                this.armor -= 15;
                break;
            }
            case struck -> {
                if (this.armor == 0) {
                    this.collect(10);
                    return;
                }
                this.armor -= 10;
            }
        }
    }

    @Override
    public void collect(int numberOfDamage){
        System.out.println("enemy is collecting damage !!! " + numberOfDamage);
        this.lifePoints -= numberOfDamage;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
