package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class DragonBoss extends Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities, Map<Integer, Integer> phases,
                      LootTable lootTable, String aiBehavior, boolean canFly,
                      boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = abilities != null ? new ArrayList<>(abilities) : new ArrayList<>();
        this.phases = phases != null ? new HashMap<>(phases) : new HashMap<>();
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage  + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            System.out.println("  - " + a.getName() + ": " + a.getDescription());
        }
        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println("  Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + " | Wingspan: " + wingspan);
        System.out.println("Loot: " + (lootTable != null ? lootTable.getLootInfo() : "None"));
    }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            clonedAbilities.add(a.clone());
        }

        LootTable clonedLoot = (this.lootTable != null) ? this.lootTable.clone() : null;

        return new DragonBoss(this.name, this.health, this.damage, this.defense, this.speed,
                this.element, clonedAbilities, new HashMap<>(this.phases), clonedLoot,
                this.aiBehavior, this.canFly, this.hasBreathAttack, this.wingspan);
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void multiplyStats(double multiplier) {
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
        this.speed = (int)(this.speed * (1 + (multiplier - 1) / 2));
    }

    public void addAbility(Ability ability) {
        if (this.abilities == null) {
            this.abilities = new ArrayList<>();
        }
        this.abilities.add(ability);
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }
}
