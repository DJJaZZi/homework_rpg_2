package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public interface EnemyComponentFactory {

    /**
     * Create the set of abilities for this theme.
     * Example: FireComponentFactory returns [FlameBreath, FireShield, MeteorStorm]
     *
     * @return list of themed abilities
     */
    List<Ability> createAbilities();

    /**
     * Create the loot table for this theme.
     * Example: FireComponentFactory returns a loot table with Fire Gems, Dragon Scales, etc.
     *
     * @return themed loot table
     */
    LootTable createLootTable();

    /**
     * Get the AI behavior type for this theme.
     * Example: FireComponentFactory returns "AGGRESSIVE"
     *
     * Think: Should this return a String, an enum, or an object?
     * Design decision is yours!
     *
     * @return AI behavior description or type
     */
    String createAIBehavior();

}
