package com.joni.entities.vocations;

import com.joni.controller.enemies.EnemyAction;
import com.joni.entities.Player;
import com.joni.entities.enemies.Enemy;

import java.math.BigDecimal;

public interface Vocation {

    void buttonW(EnemyAction enemyAction, Player player, Enemy enemy, BigDecimal reactTime);
    void buttonA(EnemyAction enemyAction, Player player, Enemy enemy);
    void buttonS(EnemyAction enemyAction, Player player, Enemy enemy);
    void buttonD(EnemyAction enemyAction, Player player, Enemy enemy);

    void skillButtonOne(EnemyAction enemyAction, Player player, Enemy enemy);
    void skillButtonTwo(EnemyAction enemyAction, Player player, Enemy enemy);
    void skillButtonThree(EnemyAction enemyAction, Player player, Enemy enemy);

}
