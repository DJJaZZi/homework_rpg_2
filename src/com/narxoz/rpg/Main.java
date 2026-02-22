package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");


        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        List<Ability> fireAbilities = fireFactory.createAbilities();
        LootTable fireLoot = fireFactory.createLootTable();
        String fireAI = fireFactory.createAIBehavior();

        List<Ability> iceAbilities = iceFactory.createAbilities();
        LootTable iceLoot = iceFactory.createLootTable();
        String iceAI = iceFactory.createAIBehavior();

        List<Ability> shadowAbilities = shadowFactory.createAbilities();
        LootTable shadowLoot = shadowFactory.createLootTable();
        String shadowAI = shadowFactory.createAIBehavior();

        System.out.println("Demonstrating Fire Factory:");
        displayThemeDemo(fireFactory);

        System.out.println("\nDemonstrating Ice Factory:");
        displayThemeDemo(iceFactory);

        System.out.println("\nDemonstrating Shadow Factory:");
        displayThemeDemo(shadowFactory);


        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");


        Enemy dragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .setCanFly(true)
                .setWingspan(30)
                .build();

        dragon.displayInfo();

        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy iceMiniBoss = director.createMiniBoss(iceFactory);
        Enemy shadowRaidBoss = director.createRaidBoss(fireFactory);
        iceMiniBoss.displayInfo();
        shadowRaidBoss.displayInfo();


        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");


        EnemyRegistry registry = new EnemyRegistry();
        Enemy baseGoblin = new BasicEnemyBuilder()
                .setName("Base Goblin")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setSpeed(10)
                .build();

        registry.registerTemplate("goblin", baseGoblin);
        registry.registerTemplate("dragon", dragon);

        Enemy eliteGoblin = registry.createFromTemplate("goblin");
        if(eliteGoblin instanceof Goblin){
            ((Goblin) eliteGoblin).multiplyStats(2.0);
            ((Goblin) eliteGoblin).addAbility(fireFactory.createAbilities().get(0));
        }
        eliteGoblin.displayInfo();
        System.out.println("Original base Goblin is not changed: ");
        baseGoblin.displayInfo();


        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");


        Enemy demonLord = new BossEnemyBuilder()
                .setName("Shadow Demon Lord")
                .setHealth(80000)
                .setDamage(600)
                .setDefense(300)
                .setSpeed(60)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAI(shadowFactory.createAIBehavior())
                .addPhase(1, 80000)
                .addPhase(2, 20000)
                .setCanFly(true)
                .setWingspan(40)
                .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy mythicDemon = registry.createFromTemplate("demon-lord");
        if (mythicDemon instanceof com.narxoz.rpg.enemy.DragonBoss) {
            ((DragonBoss) mythicDemon).multiplyStats(1.5);
        }
        mythicDemon.displayInfo();

        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("1. Abstract Factory: Guaranteed component consistency by packaging themed abilities, loot, and AI together.");
        System.out.println("2. Builder: Eliminated the 15-parameter telescoping constructor in DragonBoss, allowing clean, readable step-by-step assembly.");
        System.out.println("3. Factory Method: Used inside the 'build()' method and delegated by the EnemyDirector to output the final concrete Enemy object.");
        System.out.println("4. Prototype: Used deep-copy 'clone()' inside EnemyRegistry to spawn custom variants (like Elite Goblin) without re-running the Builder.");
        System.out.println("\n=== Demo Complete ===");
    }

    private static void displayThemeDemo(EnemyComponentFactory factory) {
        List<Ability> abilities = factory.createAbilities();
        LootTable loot = factory.createLootTable();
        String ai = factory.createAIBehavior();

        System.out.println("  - AI Behavior: " + ai);
        System.out.println("  - Abilities provided:");
        for(Ability a : abilities) {
            System.out.println("      * " + a.getName() + " (" + a.getType() + ")");
        }
        System.out.println("  - Loot Drops: " + String.join(", ", loot.getItems()));
    }
}
