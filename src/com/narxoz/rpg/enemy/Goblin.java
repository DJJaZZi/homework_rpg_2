package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;

/**
 * Example basic enemy implementation — a simple Goblin.
 *
 * This is provided as a REFERENCE to show enemy structure.
 * Study this implementation, then create more enemies.
 *
 * Notice:
 * - Simple stats (low health, low damage)
 * - Basic constructor (only a few parameters — no Builder needed!)
 * - This is intentionally simple to contrast with DragonBoss.java
 *
 * ============================================================
 * IMPORTANT OBSERVATION:
 * ============================================================
 *
 * A Goblin is simple: name, health, damage, defense — done.
 * A regular constructor works fine here:
 *     new Goblin("Forest Goblin")
 *
 * But look at DragonBoss.java... THAT'S where Builder shines!
 * Simple objects don't need Builder. Complex objects do.
 * Knowing WHEN to use a pattern is as important as knowing HOW.
 *
 * ============================================================
 * PROTOTYPE PATTERN NOTE:
 * ============================================================
 *
 * Goblin is a GREAT candidate for Prototype pattern!
 * Imagine you need 50 goblins for a dungeon. Instead of:
 *     new Goblin("Goblin 1"), new Goblin("Goblin 2"), ...
 *
 * You can:
 *     Goblin template = new Goblin("Goblin");
 *     Enemy goblin1 = template.clone();  // Fast!
 *     Enemy goblin2 = template.clone();  // Fast!
 *
 * And for variants:
 *     Enemy elite = template.clone();
 *     // modify elite's stats to 2x
 *
 * TODO: Implement the clone() method with DEEP COPY.
 * TODO: Create similar basic enemies: Skeleton, Orc, etc.
 * TODO: Consider what needs deep vs shallow copy here.
 *   - Primitive stats (health, damage) → shallow copy is fine
 *   - Ability list → MUST be deep copied!
 *   - LootTable → MUST be deep copied!
 */
public class Goblin extends Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;
    private String element;
    private String aiBehavior;


    // TODO: Add more fields as needed (element, AI behavior, etc.)

    public Goblin(String name, int health, int damage, int defense, int speed) {
        this.name = name;
        // Goblin stats: weak but fast
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = new ArrayList<>();
        this.lootTable = null;
        this.element = "NEUTRAL";
        this.aiBehavior = "BASIC_AGGRESSIVE";
        // TODO: Initialize with default abilities
        // TODO: Initialize with default loot table
    }

    // TODO: Implement methods from Enemy interface
    // You need to define those methods in Enemy first!

    // Example method structure:
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public List<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    public String getElement() {
        return element;
    }

    public String getAiBehavior() {
        return aiBehavior;
    }

    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health + " | Damage: " + damage
                + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Abilities: " + abilities.size() + " ability(ies)");
        System.out.println("Element: " + element + " | AI: " + aiBehavior);
        // TODO: Display abilities details
        if (abilities.isEmpty()) {
            System.out.println("  - None");
        } else {
            for (Ability ability : abilities) {
                System.out.println("  - " + ability.getName() + ": " + ability.getDescription());
            }
        }
        // TODO: Display loot table
        System.out.println("Loot Info:");
        if (lootTable != null) {
            System.out.println("  - " + lootTable.getLootInfo());
            System.out.println("  - Potential Items: " + String.join(", ", lootTable.getItems()));
        } else {
            System.out.println("  - No loot assigned.");
        }
        System.out.println();
    }

    // TODO: Implement clone() for Prototype pattern
    // This is CRITICAL! You must deep copy:
    //   - The abilities list (create new list, clone each ability)
    //   - The loot table (clone it)
    //   - Primitive fields can be copied directly
    //
    // Example skeleton:
    // public Enemy clone() {
    //     Goblin copy = new Goblin(this.name);
    //     copy.health = this.health;
    //     copy.damage = this.damage;
    //     copy.defense = this.defense;
    //     copy.speed = this.speed;
    //     copy.abilities = ???  // DEEP COPY! Not just = this.abilities!
    //     copy.lootTable = ???  // DEEP COPY!
    //     return copy;
    // }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name, this.health, this.damage, this.defense, this.speed);
        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;
        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }

        if (this.lootTable != null) {
            copy.lootTable = this.lootTable.clone();
        }
        return copy;
    }

    // TODO: Add helper methods for Prototype variant creation
    // Consider methods like:
    // - void multiplyStats(double multiplier) — for Elite/Champion variants
    // - void addAbility(Ability ability) — for enhanced variants
    // - void setElement(String element) — for elemental variants

    public void multiplyStats(double multiplier) {
        this.health = (int)(this.health * multiplier);
        this.damage = (int)(this.damage * multiplier);
        this.defense = (int)(this.defense * multiplier);
    }

    public void addAbility(Ability ability){
        this.abilities.add(ability);
    }

    public void setElement(String element){
        this.element = element;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }
}
