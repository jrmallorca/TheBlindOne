package com.joni.entities;

import com.joni.entities.vocations.Vocation;

public class Player {

    private String name;
    private int hp;
    private int mp;
    private Vocation vocation;

    public Player(String name, int hp, int mp, Vocation vocation) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.vocation = vocation;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public Vocation getVocation() {
        return vocation;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setVocation(Vocation vocation) {
        this.vocation = vocation;
    }
}
