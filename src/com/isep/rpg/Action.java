package com.isep.rpg;

public interface Action {
    boolean isDead();
    Attack attack(Attack attack);
    void defend(Attack attack);
    void collect(int numberOfDamage);
}
