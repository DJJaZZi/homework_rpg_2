package com.narxoz.rpg.combat;

public class Vanish implements Ability {

    private String name;
    private int damage;
    private int evasionChance;
    private String description;
    private AbilityType type;

    public Vanish() {
        this.name = "Vanish";
        this.damage = 0;
        this.evasionChance = 80;
        this.description = "The caster disappears into the darkness, granting " + evasionChance + " evasion chance against incoming attacks.";
        this.type = AbilityType.BUFF;
    }

    public int getEvasionChance() {
        return evasionChance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public AbilityType getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setEvasionChance(int evasionChance) {
        this.evasionChance = evasionChance;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    @Override
    public Ability clone() {
        Vanish copy = new Vanish();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.evasionChance = this.evasionChance;
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}