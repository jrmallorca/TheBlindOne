package com.joni.entities.enemies;

import com.joni.controller.enemies.EnemyAction;

import java.math.BigDecimal;
import java.security.SecureRandom;

public class Enemy {

    private short hp;
    private short mp;

    private String leftATK;
    private String rightATK;
    private String forwardATK;
    private BigDecimal attackTime;

    // For getting a randomEnum. Randomly chooses which enemyAction happens
    private static final SecureRandom random = new SecureRandom();

    Enemy(short hp, short mp, String leftATK, String rightATK, String forwardATK, BigDecimal attackTime) {
        this.hp = hp;
        this.mp = mp;
        this.leftATK = leftATK;
        this.rightATK = rightATK;
        this.forwardATK = forwardATK;
        this.attackTime = attackTime;
    }

    public  <T extends Enum<?>> T randomEnum(Class<T> c){
        int x = random.nextInt(c.getEnumConstants().length);
        return c.getEnumConstants()[x];
    }

    public String enemyActionString(EnemyAction enemyAction) {
        switch (enemyAction) {
            case L_ATK:
                return leftATK;
            case F_ATK:
                return forwardATK;
            case R_ATK:
                return rightATK;
            default:
                return "Error";
        }
    }

    public String getLeftATK() {
        return leftATK;
    }

    public String getRightATK() {
        return rightATK;
    }

    public String getForwardATK() {
        return forwardATK;
    }

    public BigDecimal getAttackTime() {
        return attackTime;
    }

    public short getHp() {
        return hp;
    }

    public short getMp() {
        return mp;
    }

    public void setHp(short hp) {
        this.hp = hp;
    }

    public void setMp(short mp) {
        this.mp = mp;
    }
}
