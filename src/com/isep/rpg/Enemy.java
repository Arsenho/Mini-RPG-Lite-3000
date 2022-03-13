package com.isep.rpg;

public abstract class Enemy {
    protected int lifePoints;

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
}
