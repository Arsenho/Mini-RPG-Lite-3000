package com.isep.rpg;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    @Test
    public void testNumberOfEnemies(){
        Game game = new Game(45);
        assertNotEquals(46, game.getNumberOfEnemies());
    }

    @Test
    public void testHunterDeadStateEqualsZero(){
        Hunter hunter = new Hunter();
        hunter.setLifePoints(0);
        assertTrue(hunter.isDead());
    }

    @Test
    public void testHunterDeadStateEqualsNegative(){
        Hunter hunter = new Hunter();
        hunter.setLifePoints(-4);
        assertTrue(hunter.isDead());
    }

    @Test
    public void testGameContinueState(){
        Game game = new Game(45);
        Hunter hunter = new Hunter();
        hunter.setLifePoints(0);

        Warrior warrior = new Warrior();
        warrior.setLifePoints(0);

        Healer healer = new Healer();
        healer.setManaPoints(50);
        healer.setLifePoints(0);

        Mage mage = new Mage();
        mage.setLifePoints(0);

        game.heroes.add(hunter);
        game.heroes.add(warrior);
        game.heroes.add(healer);
        game.heroes.add(mage);

        assertTrue(game.isGameOver());
    }

    @Test
    public void testWonGame(){
        Game game = new Game(45);
        Hunter hunter = new Hunter();
        hunter.setLifePoints(10);

        Warrior warrior = new Warrior();
        warrior.setLifePoints(10);

        Healer healer = new Healer();
        healer.setManaPoints(50);
        healer.setLifePoints(10);

        Mage mage = new Mage();
        mage.setLifePoints(10);

        game.heroes.add(hunter);
        game.heroes.add(warrior);
        game.heroes.add(healer);
        game.heroes.add(mage);

        BasicEnemy basicEnemy = new BasicEnemy();
        basicEnemy.setLifePoints(0);

        Boss boss = new Boss();
        boss.setLifePoints(0);

        game.enemies.add(basicEnemy);
        game.enemies.add(boss);

        assertTrue(game.hasWon());
    }

    @Test
    public void testHunterArrowsReward(){
        Game game = new Game(45);
        Hunter hunter = new Hunter();
        hunter.setLifePoints(10);
        hunter.setArrows(10);

        game.heroes.add(hunter);


        game.grantRewards();
        assertTrue(game.hasWon());
        assertEquals(15, hunter.getArrows());
    }

}
