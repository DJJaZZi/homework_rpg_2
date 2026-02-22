package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;
import java.util.ArrayList;


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
    }

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
        if (abilities.isEmpty()) {
            System.out.println("  - None");
        } else {
            for (Ability ability : abilities) {
                System.out.println("  - " + ability.getName() + ": " + ability.getDescription());
            }
        }
        System.out.println("Loot Info:");
        if (lootTable != null) {
            System.out.println("  - " + lootTable.getLootInfo());
            System.out.println("  - Potential Items: " + String.join(", ", lootTable.getItems()));
        } else {
            System.out.println("  - No loot assigned.");
        }
        System.out.println();
    }

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
