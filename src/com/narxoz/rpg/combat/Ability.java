package com.narxoz.rpg.combat;

public interface Ability {

    enum AbilityType {
        DAMAGE, BUFF, DEBUFF, ULTIMATE
    }
    String getName();
    int getDamage();
    String getDescription();
    AbilityType getType();
    Ability clone();
}
