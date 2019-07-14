package com.joni.entities.enemies;

import java.math.BigDecimal;

public class Enemy {

    private String leftATK;
    private String rightATK;
    private String forwardATK;
    private BigDecimal attackTime;

    Enemy(String leftATK, String rightATK, String forwardATK, BigDecimal attackTime) {
        this.leftATK = leftATK;
        this.rightATK = rightATK;
        this.forwardATK = forwardATK;
        this.attackTime = attackTime;
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
}
