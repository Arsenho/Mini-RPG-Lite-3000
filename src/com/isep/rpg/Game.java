package com.isep.rpg;

import com.isep.utils.InputParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    protected int playerTurn;
    protected InputParser inputParser;
    protected List<Hero> heroes;
    protected List<Enemy> enemies;
    protected int numberOfEnemies;
    protected int numberOfHeroes;


    public boolean gameState;

    public Game() {
        heroes = new ArrayList<>();
        enemies = new ArrayList<>();
    }

    public Game(int numberOfHeroes) {
        heroes = new ArrayList<>();
        enemies = new ArrayList<>();

        this.numberOfHeroes = numberOfHeroes;
        setNumberOfEnemies(numberOfHeroes);
    }

    public void playGame() {
    }

    public void generateCombat() {
    }

    public void setNumberOfEnemies(int numberOfEnemies) {
        Random rand = new Random();
        this.numberOfEnemies = rand.nextInt(this.numberOfHeroes);
    }

    public int getNumberOfEnemies() {
        return this.numberOfEnemies;
    }

    public boolean isGameOver() {
        int counter = 0;
        for (Hero hero : heroes) {
            if (hero.isDead())
                counter++;
        }
        return counter == heroes.size();
    }

    public boolean hasWon() {
        if (isGameOver())
            return false;

        int counter = 0;
        for (Enemy enemy : enemies) {
            if (enemy.isDead())
                counter++;
        }

        return counter == enemies.size();
    }

    public void rewards(Hero hero, REWARD_TYPE reward) {
        switch (reward) {
            case ADD_ARMOR:
                hero.addArmor(5);
                break;
            case ADD_ARMOR_DAMAGE:
                break;
            case ADD_POTION:
                Potion potion = new Potion();
                hero.potions.add(potion);
                break;
            case ADD_FOOD:
                Food food = new Food();
                hero.lembas.add(food);
                break;
            case ADD_ARROWS:
                if (hero instanceof Hunter){
                    ((Hunter) hero).addArrow(5);
                }
                break;
            case REDUCE_MANA_COST:
                break;
            case ADD_SPELL_EFFICIENCY:
                break;
            default:
                System.out.println("invalid Choice! Please choose correct choice.");
        }
    }

    public void grantRewards() {
        REWARD_TYPE reward = REWARD_TYPE.ADD_ARMOR;
       for(Hero hero : heroes){
           if (hero instanceof Hunter)
               reward = REWARD_TYPE.ADD_ARROWS;
           rewards(hero, reward);
       }

    }
}
