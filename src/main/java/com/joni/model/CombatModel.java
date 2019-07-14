package com.joni.model;

import com.joni.controller.enemies.Attack;
import javafx.scene.input.KeyCode;

import java.security.SecureRandom;

public class CombatModel {

    private static final SecureRandom random = new SecureRandom();

    void determineEffect(KeyCode keyCode, Attack attack) {
        switch (keyCode) {
            case W:

                switch (attack) {
                    case L_ATK:
                        break;
                    case R_ATK:
                        break;
                    case F_ATK:
                        break;
                }

                break;
            case A:

                switch (attack) {
                    case L_ATK:
                        break;
                    case R_ATK:
                        break;
                    case F_ATK:
                        break;
                }

                break;
            case S:

                switch (attack) {
                    case L_ATK:
                        break;
                    case R_ATK:
                        break;
                    case F_ATK:
                        break;
                }

                break;
            case D:

                switch (attack) {
                    case L_ATK:
                        break;
                    case R_ATK:
                        break;
                    case F_ATK:
                        break;
                }

                break;
//            case DIGIT1:
//                break;
//            case DIGIT2:
//                break;
//            case DIGIT3:
//                break;
        }
    }

    public  <T extends Enum<?>> T randomEnum(Class<T> c){
        int x = random.nextInt(c.getEnumConstants().length);
        return c.getEnumConstants()[x];
    }

}
