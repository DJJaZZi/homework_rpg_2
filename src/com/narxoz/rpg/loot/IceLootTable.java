package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable{

    private List<String> items;
    private int goldDrop;
    private int experienceDrop;

    public IceLootTable() {
        this.items = new ArrayList<>();
        this.items.add("Ice Gem");
        this.items.add("Frost Scale");
        this.items.add("Ice Rune");
        this.goldDrop = 400;
        this.experienceDrop = 1100;
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
        return "Ice Theme Loot: Drops freezing cold materials.";
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
        IceLootTable copy = new IceLootTable();
        copy.items = new ArrayList<>(this.items);
        copy.goldDrop = this.goldDrop;
        copy.experienceDrop = this.experienceDrop;
        return copy;
    }
}
