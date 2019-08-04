package com.joni.entities.vocations;

import com.joni.controller.enemies.EnemyAction;
import com.joni.entities.Player;
import com.joni.entities.enemies.Enemy;

import java.math.BigDecimal;

public class Fighter implements Vocation {

    private BigDecimal interruptTimeThreshold = new BigDecimal("0.5");

    @Override // Interrupt
    public void buttonW(EnemyAction enemyAction, Player player, Enemy enemy, BigDecimal reactTime) {
        switch (enemyAction) {
            case L_ATK:
            case F_ATK:
            case R_ATK:
//                if (interruptTimeThreshold.compareTo(reactTime) >= 0)
//                    interruptSuccess(Player player, Enemy enemy);
//                else
//                    interruptFailure(Player player, Enemy enemy);
                break;
        }
    }

    @Override // Dodge left
    public void buttonA(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

    // TODO: 24/07/2019 Try limiting how many blocks allowed
    @Override // Block
    public void buttonS(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

    @Override // Dodge right
    public void buttonD(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

    @Override
    public void skillButtonOne(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

    @Override
    public void skillButtonTwo(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

    @Override
    public void skillButtonThree(EnemyAction enemyAction, Player player, Enemy enemy) {
        switch (enemyAction) {
            case L_ATK:
                break;
            case F_ATK:
                break;
            case R_ATK:
                break;
        }
    }

}
