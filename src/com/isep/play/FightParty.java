package com.isep.play;

import com.isep.rpg.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FightParty {
    public List<Fight> fights;
    public List<Hero> heroes;
    public final int numberOfFight = 5;
    public final int lifePointBound = 500;
    public boolean isGameOver;

    public FightParty(){
        this.fights = new ArrayList<>();
        this.heroes = new ArrayList<>();
        initHeroes();
        initFights();
    }

    private void initHeroes(){
        Random random = new Random();
        int lifePoints, weaponDamage, armor;
        Hero hunter, healer, mage, warrior;

        lifePoints = random.nextInt(30, lifePointBound);
        weaponDamage = random.nextInt(30, lifePointBound);
        armor = random.nextInt(30, lifePointBound);

        hunter = new Hunter(lifePoints, armor, weaponDamage);
        heroes.add(hunter);

        lifePoints = random.nextInt(30, lifePointBound);
        weaponDamage = random.nextInt(30, lifePointBound);
        armor = random.nextInt(30, lifePointBound);

        healer = new Healer(lifePoints, armor, weaponDamage);
        heroes.add(healer);

        lifePoints = random.nextInt(30, lifePointBound);
        weaponDamage = random.nextInt(30, lifePointBound);
        armor = random.nextInt(30, lifePointBound);

        mage = new Mage(lifePoints, armor, weaponDamage);
        heroes.add(mage);

        lifePoints = random.nextInt(30, lifePointBound);
        weaponDamage = random.nextInt(30, lifePointBound);
        armor = random.nextInt(30, lifePointBound);

        warrior = new Warrior(lifePoints, armor, weaponDamage);
        heroes.add(warrior);
    }

    public void initFights(){
        for (int i = 0; i < numberOfFight; i++) {
            Fight fight = new Fight(heroes);
            this.fights.add(fight);
        }
    }

    public void start(){
        Random random = new Random();
        for (Fight round : this.fights) {
            while (!round.isEnemyFinish()){
                System.out.println("still fighting !!!");
                round.start();

                if (round.isHeroFinish()) {
                    System.out.println("Round is Over !!!!");
                    this.isGameOver = true;
                    break;
                }
            }

            if (isGameOver){
                System.out.println("Game Over !!!!");
                return;
            }
            System.out.println("\n\nanother round will start\n\n");
            this.receiveCompensation();

        }
        System.out.println("\n\nYour teams worn the battle !!!\n\n");
    }

    public void receiveCompensation(){
        System.out.println("receiving compensation wouf wouf !!!!");
        Random random = new Random();
        int chooseCompensation = random.nextInt(0, 7);
        int compensation = 0;
        for (Hero hero : this.heroes) {
            switch (chooseCompensation){
                case 0:
                    compensation = random.nextInt(5, 10);
                    hero.addArmor(compensation);
                    break;
                case 1:
                    compensation = random.nextInt(5, 10);
                    hero.addWeaponDamage(compensation);
                    break;
                case 2:
                    compensation = random.nextInt(5, 10);
                    hero.addPotion(compensation);
                    break;
                case 3:
                    compensation = random.nextInt(5, 10);
                    hero.addLembas(compensation);
                    break;
                case 4:
                    compensation = random.nextInt(5, 10);
                    List<Potion> potions = new ArrayList<>();
                    for (Potion potion: hero.getPotions()) {
                        potion.changeEfficiency(compensation);
                        potions.add(potion);
                    }
                    hero.setPotions(potions);
                    break;
                case 5:
                    compensation = random.nextInt(5, 10);
                    List<Food> foods = new ArrayList<>();
                    for (Food food: hero.getLembas()) {
                        food.changeEfficiency(compensation);
                        foods.add(food);
                    }
                    hero.setLembas(foods);
                    break;
                case 6:
                    compensation = random.nextInt(5, 10);
                    if (Hunter.class.isInstance(hero)) {
                        ((Hunter) hero).addArrow(compensation);
                    }
                    break;
            }
        }
        switch (chooseCompensation){

        }
    }

}
