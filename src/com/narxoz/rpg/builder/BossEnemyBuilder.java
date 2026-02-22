package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder{

    private String name;
    private int health;
    private int damage = 100; // Default boss values
    private int defense = 50;
    private int speed = 20;
    private String element = "NEUTRAL";
    private String aiBehavior = "BOSS_TACTICAL";

    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable lootTable;

    private boolean canFly = false;
    private boolean hasBreathAttack = false;
    private int wingspan = 0;

    @Override
    public EnemyBuilder setName(String name) { this.name = name; return this; }

    @Override
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }

    @Override
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }

    @Override
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }

    @Override
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override
    public EnemyBuilder setElement(String element) { this.element = element; return this; }

    @Override
    public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }

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
    public EnemyBuilder setLootTable(LootTable loot) { this.lootTable = loot; return this; }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        this.phases.put(phaseNumber, healthThreshold);
        return this;
    }

    @Override
    public EnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }

    @Override
    public EnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    // FACTORY METHOD: build() is the factory method.
    // It validates the fields and acts as the creator, returning a concrete Enemy product.
    @Override
    public Enemy build() {
        if (name == null || name.isEmpty()) {
            throw new IllegalStateException("Boss must have a name!");
        }
        if (health <= 0) {
            throw new IllegalStateException("Boss health must be greater than zero!");
        }

        for (Ability a : abilities) {
            if (a.getName().toLowerCase().contains("breath")) {
                this.hasBreathAttack = true;
                break;
            }
        }

        return new DragonBoss(  name, health, damage, defense, speed, element,
                                abilities, phases, lootTable, aiBehavior,
                                canFly, hasBreathAttack, wingspan);
    }
}
