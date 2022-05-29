package com.isep.play;

import com.isep.rpg.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Fight {
    public List<Hero> heroes;
    public List<Enemy> enemies;
    public boolean isHeroWin;
    public boolean isEnemyWin;

    public Fight() {

    }

    public Fight(List<Hero> heroes) {
        this.heroes = heroes;
        this.enemies = new ArrayList<>();
        this.isEnemyWin = true;
        this.isHeroWin = true;
        System.out.println("heroes = " + heroes.size());
        generateEnemies();
    }

    public Fight(List<Hero> heroes, List<Enemy> enemies) {
        this.heroes = heroes;
        this.enemies = enemies;
    }

    public boolean isHeroFinish() {
        int numberOfHeroDead = 0;
        for (Hero hero : heroes) {
            if (hero.isDead()) {
                numberOfHeroDead++;
                //System.out.println("Number of hero dead == " + numberOfHeroDead);
            }
        }
        System.out.println("Number of hero dead == " + numberOfHeroDead);
        if (numberOfHeroDead == heroes.size()) {
            isHeroWin = false;
            return true;
        }
        return false;
    }

    public boolean isEnemyFinish() {
        int numberOfEnemyDead = 0;
        for (Enemy enemy : enemies) {
            if (enemy.isDead()) {
                numberOfEnemyDead++;
            }
        }
        System.out.println("Number of enemy dead == " + numberOfEnemyDead);
        if (numberOfEnemyDead == enemies.size()) {
            isEnemyWin = false;
            return true;
        }
        return false;
    }

    public boolean isFinish() {
        System.out.println("");
        return isEnemyFinish() || isHeroFinish();
    }

    private void generateEnemies() {
        Random random = new Random();
        int lifePoints, weaponDamage, enemyLifePoint = 100;
        int numberOfHeroes = this.heroes.size();
        int numberOfEnemies = random.nextInt((int) Math.pow(2, numberOfHeroes));
        System.out.println("numberOfEnemies = " + numberOfEnemies);
        for (int i = 0; i < numberOfEnemies; i++) {
            int enemyType = random.nextInt(0, 2);
            Enemy enemy;
            switch (enemyType) {
                case 0:
                    lifePoints = random.nextInt(30, enemyLifePoint);
                    weaponDamage = random.nextInt(30, enemyLifePoint);
                    enemy = new BasicEnemy(lifePoints, weaponDamage);
                    enemies.add(enemy);
                    break;
                case 1:
                    lifePoints = random.nextInt(30, enemyLifePoint);
                    weaponDamage = random.nextInt(30, enemyLifePoint);
                    enemy = new Boss(lifePoints, weaponDamage);
                    enemies.add(enemy);
                    break;
            }
        }
    }

    private void heroAttacks(Hero hero) {
        if (Hunter.class.isInstance(hero)) {
            Hunter hunter = (Hunter) hero;
            Attack heroAttack = hunter.attack(Attack.arrow);
            this.handleHeroFight(hunter, heroAttack);
        } else if (Healer.class.isInstance(hero)) {
            Healer healer = (Healer) hero;
            Attack healerAttack = healer.attack(Attack.heal);
            this.handleHeroFight(healer, healerAttack);
        } else if (Mage.class.isInstance(hero)) {
            Mage mage = (Mage) hero;
            Attack mageAttack = mage.attack(Attack.wish);
            this.handleHeroFight(mage, mageAttack);
        } else if (Warrior.class.isInstance(hero)) {
            Warrior warrior = (Warrior) hero;
            Attack warriorAttack;
            warriorAttack = warrior.attack(Attack.hit);
            this.handleHeroFight(warrior, warriorAttack);
            warriorAttack = warrior.attack(Attack.struck);
            this.handleHeroFight(warrior, warriorAttack);
        }
        useConsumable(hero);
    }

    private void enemyAttacks(Enemy enemy) {
        if (BasicEnemy.class.isInstance(enemy)) {
            Attack enemyAttack = enemy.attack(Attack.enemy);
            handleEnemyFight(enemy, enemyAttack);
        } else if (Boss.class.isInstance(enemy)) {
            Attack enemyAttack = enemy.attack(Attack.enemy);
            handleEnemyFight(enemy, enemyAttack);
        }
    }

    public void start() {
        Random random = new Random();
        int teamToAttack = random.nextInt(0, 2);

        switch (teamToAttack) {
            case 0:
                int heroToAttackIndex = random.nextInt(0, heroes.size());
                while (heroes.get(heroToAttackIndex).isDead()) {
                    heroToAttackIndex = random.nextInt(0, heroes.size());
                }
                Hero hero = heroes.get(heroToAttackIndex);
                this.heroAttacks(hero);
                break;
            case 1:
                int enemyToAttackIndex = random.nextInt(0, enemies.size());
                while (enemies.get(enemyToAttackIndex).isDead()) {
                    enemyToAttackIndex = random.nextInt(0, enemies.size());
                }
                Enemy enemy = enemies.get(enemyToAttackIndex);
                this.enemyAttacks(enemy);
                break;
        }
    }

    private void useConsumable(Hero hero) {
        Random random = new Random();
        int chooseConsumable = random.nextInt(0, 3);
        switch (chooseConsumable) {
            case 0:
                break;
            case 1:
                hero.eatLembas();
                break;
            case 2:
                hero.drinkPotion();
                break;
        }
    }

    private void handleHeroFight(Hero hero, Attack attack) {
        Random random = new Random();
        int enemyToCollectIndex = random.nextInt(0, enemies.size());
        Enemy enemy = enemies.get(enemyToCollectIndex);

        int enemyAction = random.nextInt(0, 2);
        switch (enemyAction) {
            case 0:
                enemy.defend(attack);
                break;
            case 1:
                enemy.collect(hero.getWeaponDamage());
                break;
        }
    }

    private void handleEnemyFight(Enemy enemy, Attack attack) {
        Random random = new Random();
        int heroToCollectIndex = random.nextInt(0, heroes.size());
        Hero hero = heroes.get(heroToCollectIndex);

        int heroAction;
        heroAction = random.nextInt(0, 2);

        switch (heroAction) {
            case 0:
                hero.defend(attack);
                break;
            case 1:
                hero.collect(enemy.getWeaponDamage());
                break;
        }
    }
}
