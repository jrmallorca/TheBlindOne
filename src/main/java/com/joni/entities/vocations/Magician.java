package com.joni.entities.vocations;

import com.joni.controller.enemies.EnemyAction;
import com.joni.entities.Player;
import com.joni.entities.enemies.Enemy;

import java.math.BigDecimal;

public class Magician implements Vocation {

    private BigDecimal interruptTimeThreshold = new BigDecimal("0.5");

    @Override
    public void buttonW(EnemyAction enemyAction, Player player, Enemy enemy, BigDecimal reactTime) {

    }

    @Override
    public void buttonA(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

    @Override
    public void buttonS(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

    @Override
    public void buttonD(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

    @Override
    public void skillButtonOne(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

    @Override
    public void skillButtonTwo(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

    @Override
    public void skillButtonThree(EnemyAction enemyAction, Player player, Enemy enemy) {

    }

}
