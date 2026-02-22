package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    public abstract void displayInfo();
    public abstract Enemy clone();
}
