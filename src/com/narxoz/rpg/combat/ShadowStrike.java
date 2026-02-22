package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {

    private String name;
    private int damage;
    private String description;
    private AbilityType type;

    public ShadowStrike() {
        this.name = "Shadow Strike";
        this.damage = 120;
        this.description = "A swift, deadly attack from the shadows that deals massive damage and blinds the target.";
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
        ShadowStrike copy = new ShadowStrike();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}