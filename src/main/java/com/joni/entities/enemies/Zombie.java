package com.joni.entities.enemies;

import java.math.BigDecimal;

public class Zombie extends Enemy {

    public Zombie() {
        super("A hand comes to your left",
              "A hand swung to your right",
              "The zombie lunges forward to bite",
              new BigDecimal("1.5"));
    }

}
