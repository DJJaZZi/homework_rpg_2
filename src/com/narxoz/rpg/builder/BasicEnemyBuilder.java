package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {
    private String name;
    private int health;
    private int damage = 10;
    private int defense = 2;
    private int speed = 5;
    private String element = "NEUTRAL";
    private String aiBehavior = "BASIC_AGGRESSIVE";
    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override
    public EnemyBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EnemyBuilder setHealth(int health) {
        this.health = health;
        return this;
    }

    @Override
    public EnemyBuilder setDamage(int damage) {
        this.damage = damage;
        return this;
    }

    @Override
    public EnemyBuilder setDefense(int defense) {
        this.defense = defense;
        return this;
    }

    @Override
    public EnemyBuilder setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    @Override
    public EnemyBuilder setElement(String element) {
        this.element = element;
        return this;
    }

    @Override
    public EnemyBuilder setAI(String ai) {
        this.aiBehavior = ai;
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        this.abilities.add(ability);
        return this;
    }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>(abilities);
        return this;
    }

    @Override
    public EnemyBuilder setLootTable(LootTable loot) {
        this.lootTable = loot;
        return this;
    }

    @Override
    public EnemyBuilder addPhase(int p, int h) { return this; }
    @Override
    public EnemyBuilder setCanFly(boolean f) { return this; }
    @Override
    public EnemyBuilder setWingspan(int w) { return this; }

    // FACTORY METHOD: build() is the factory method.
    // It validates the fields and acts as the creator, returning a concrete Enemy product.
    @Override
    public Enemy build() {
        if (name == null || name.isEmpty() || health <= 0) {
            throw new IllegalStateException("Name and positive Health are required!");
        }
        Goblin goblin = new Goblin(name, health, damage, defense, speed);
        goblin.setElement(this.element);
        goblin.setLootTable(this.lootTable);
        for (Ability a : this.abilities) {
            goblin.addAbility(a);
        }
        return goblin;
    }
}