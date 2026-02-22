package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable{
    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public ShadowLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Shadow Gem");
        this.items.add("Dark Essence");
        this.items.add("Shadow Rune");
        this.goldDrop = 800;
        this.experienceDrop = 1200;
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
        return "Shadow Theme Loot: Drops dark, mysterious materials.";
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
        ShadowLootTable copy = new ShadowLootTable();
        copy.items = new ArrayList<>(this.items);
        copy.goldDrop = this.goldDrop;
        copy.experienceDrop = this.experienceDrop;
        return copy;
    }
}
