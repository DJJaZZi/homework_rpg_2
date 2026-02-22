package com.narxoz.rpg.loot;


import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable{

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public FireLootTable(){
        this.items = new ArrayList<>();
        this.items.add("Fire Gem");
        this.items.add("Dragon Scale");
        this.items.add("Flame Rune");
        this.goldDrop = 300;
        this.experienceDrop = 1000;
    }

    @Override
    public List<String> getItems() {
        return items;
    }

    @Override
    public int getGoldDrop() {
        return goldDrop;
    }

    @Override
    public int getExperienceDrop() {
        return experienceDrop;
    }

    @Override
    public String getLootInfo() {
        return "Fire Theme Loot: Drops rare materials.";
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    public void setExperienceDrop(int experienceDrop) {
        this.experienceDrop = experienceDrop;
    }

    @Override
    public LootTable clone() {
        FireLootTable copy = new FireLootTable();
        copy.items = new ArrayList<>(this.items);
        copy.goldDrop = this.goldDrop;
        copy.experienceDrop = this.experienceDrop;
        return copy;
    }
}
