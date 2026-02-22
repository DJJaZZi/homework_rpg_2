package com.narxoz.rpg.combat;

public class FireShield implements Ability{

    private String name;
    private int damage;
    private int defenseBoost;
    private String description;
    private AbilityType type;

    public FireShield(){
        this.name = "Fire Shield";
        this.damage = 0;
        this.defenseBoost = 60;
        this.description = "Surrounds the caster in a shield of flames, increasing defense by " + defenseBoost + ".";
        this.type = AbilityType.BUFF;
    }

    public int getDefenseBoost(){
        return defenseBoost;
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

    public void setDefenseBoost(int defenseBoost) {
        this.defenseBoost = defenseBoost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    @Override
    public Ability clone() {
        FireShield copy = new FireShield();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.defenseBoost = this.defenseBoost;
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}
