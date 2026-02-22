package com.narxoz.rpg.combat;

public class FlameBreath implements Ability{
    private String name;
    private int damage;
    private String description;
    private AbilityType type;

    public FlameBreath(){
        this.name = "Flame Breath";
        this.damage = 75;
        this.description = "Breathes fire causing AoE damage and applying a burn effect";
        this.type = AbilityType.DAMAGE;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(AbilityType type) {
        this.type = type;
    }

    @Override
    public Ability clone() {
        FlameBreath copy = new FlameBreath();
        copy.name = this.name;
        copy.damage = this.damage;
        copy.description = this.description;
        copy.type = this.type;
        return copy;
    }
}
