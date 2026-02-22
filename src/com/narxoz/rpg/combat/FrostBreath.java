package com.narxoz.rpg.combat;

public class FrostBreath implements Ability{

    private String name;
    private int damage;
    private String description;
    private AbilityType type;

    public FrostBreath(){
        this.name = "Frost Breath";
        this.damage = 75;
        this.description = "Breathes a cone of freezing air, dealing damage and severely slowing enemies.";
        this.type = AbilityType.DAMAGE;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    @Override
    public Ability clone() {
        FrostBreath copy = new FrostBreath();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}
