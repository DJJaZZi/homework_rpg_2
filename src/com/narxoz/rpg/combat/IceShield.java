package com.narxoz.rpg.combat;

public class IceShield implements Ability{

    private String name;
    private int damage;
    private int defenseBoost;
    private String description;
    private AbilityType type;

    public IceShield(){
        this.name =  "Ice Shield";
        this.damage = 0;
        this.defenseBoost = 45;
        this.description = "Encases the caster in thick ice, increasing defense by " + defenseBoost + " and absorbing physical blows.";
        this.type = type;
    }

    public int getDefenseBoost(){
        return defenseBoost;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public AbilityType getType() {
        return null;
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
        IceShield copy = new IceShield();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.defenseBoost = this.defenseBoost; // <--- Deep copy the stat boost
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}
