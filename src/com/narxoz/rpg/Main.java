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

/**
 * Main demonstration class for the RPG Enemy System.
 *
 * ============================================================
 * CREATIONAL PATTERNS CAPSTONE
 * ============================================================
 *
 * This demo must showcase ALL FOUR creational design patterns
 * working together in one unified system:
 *
 *   1. ABSTRACT FACTORY — Create themed enemy component families
 *   2. BUILDER          — Construct complex enemies step-by-step
 *   3. FACTORY METHOD   — Embedded in Builder.build() and Director
 *   4. PROTOTYPE        — Clone enemies into variants efficiently
 *
 * The patterns work together in a pipeline:
 *
 *   Abstract Factory (themed components)
 *          |
 *          v
 *   Builder (assembles enemy from components)
 *          |
 *          v  <-- Factory Method: build() produces the Enemy
 *   Prototype (clones built enemy into variants)
 *
 * ============================================================
 * YOUR TASKS:
 * ============================================================
 *
 * Your Main.java should demonstrate each pattern clearly,
 * then show them working together. Follow the structure below.
 *
 * Expected output flow:
 *   Part 1: Abstract Factory creates themed components
 *   Part 2: Builder constructs complex enemies
 *   Part 3: Prototype clones enemies into variants
 *   Part 4: Full pipeline — all patterns integrated
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        // ============================================================
        // PART 1: ABSTRACT FACTORY PATTERN
        // ============================================================
        // TODO: Create themed component factories
        //   - FireComponentFactory
        //   - IceComponentFactory
        //   - ShadowComponentFactory
        //
        // TODO: Show that each factory creates MATCHING components
        //   EnemyComponentFactory fireFactory = new FireComponentFactory();
        //   List<Ability> fireAbilities = fireFactory.createAbilities();
        //   LootTable fireLoot = fireFactory.createLootTable();
        //   String fireAI = fireFactory.createAIBehavior();
        //
        // TODO: Display the components from each factory
        //   Show that Fire factory creates fire abilities + fire loot
        //   Show that Ice factory creates ice abilities + ice loot
        //   Show that they CANNOT be mixed (consistency guaranteed!)
        //
        // Think: How is this similar to HW1's EquipmentFactory?

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        // Your Abstract Factory demonstration here...

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



        // ============================================================
        // PART 2: BUILDER PATTERN
        // ============================================================
        // TODO: Build complex enemies using your EnemyBuilder
        //
        // Build at least:
        //   - One complex boss (Dragon) using BossEnemyBuilder
        //     Use the FireComponentFactory to get themed components!
        //   - One medium enemy using BasicEnemyBuilder
        //
        // TODO: Show the fluent interface in action:
        //   Enemy dragon = new BossEnemyBuilder()
        //       .setName("Ancient Fire Dragon")
        //       .setHealth(50000)
        //       .setDamage(500)
        //       .setAbilities(fireFactory.createAbilities())
        //       .setLootTable(fireFactory.createLootTable())
        //       .addPhase(1, 50000)
        //       .addPhase(2, 30000)
        //       .addPhase(3, 15000)
        //       .build();
        //
        // TODO: Show the Director creating preset enemies:
        //   EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        //   Enemy miniBoss = director.createMiniBoss();
        //   Enemy raidBoss = director.createRaidBoss();
        //
        // Think: Where is Factory Method here? (Hint: build() IS the factory method!)
        // Think: How does the Director use Factory Method delegation?

        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        // Your Builder demonstration here...

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

        // ============================================================
        // PART 3: PROTOTYPE PATTERN
        // ============================================================
        // TODO: Create a template registry and populate it
        //   EnemyRegistry registry = new EnemyRegistry();
        //   registry.registerTemplate("goblin", baseGoblin);
        //   registry.registerTemplate("dragon", baseDragon);
        //
        // TODO: Clone enemies to create difficulty variants
        //   Enemy eliteGoblin = registry.createFromTemplate("goblin");
        //   eliteGoblin.multiplyStats(2.0);  // 2x stats
        //
        // TODO: Clone enemies to create elemental variants
        //   Enemy fireDragon = registry.createFromTemplate("dragon");
        //   fireDragon.setElement("FIRE");
        //   fireDragon.setAbilities(fireFactory.createAbilities());
        //
        // TODO: Prove deep copy works!
        //   Modify cloned enemy's abilities.
        //   Show that the original template is UNCHANGED.
        //
        // Think: What would happen with shallow copy here?

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        // Your Prototype demonstration here...

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

        // ============================================================
        // PART 4: ALL PATTERNS WORKING TOGETHER
        // ============================================================
        // TODO: Show the full pipeline
        //
        // Step 1: Abstract Factory creates Shadow components
        //   EnemyComponentFactory shadowFactory = new ShadowComponentFactory();
        //
        // Step 2: Builder assembles Demon Lord with Shadow components
        //   Enemy demonLord = new BossEnemyBuilder()
        //       .setName("Demon Lord")
        //       .setAbilities(shadowFactory.createAbilities())
        //       .setLootTable(shadowFactory.createLootTable())
        //       .build();
        //
        // Step 3: Register as Prototype template
        //   registry.registerTemplate("demon-lord", demonLord);
        //
        // Step 4: Clone variants
        //   Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        //   greaterDemon.multiplyStats(2.0);
        //
        // Display all variants showing each pattern's contribution!

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        // Your integration demonstration here...

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
        // ============================================================
        // SUMMARY
        // ============================================================
        System.out.println("============================================");
        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("1. Abstract Factory: Guaranteed component consistency by packaging themed abilities, loot, and AI together.");
        System.out.println("2. Builder: Eliminated the 15-parameter telescoping constructor in DragonBoss, allowing clean, readable step-by-step assembly.");
        System.out.println("3. Factory Method: Used inside the 'build()' method and delegated by the EnemyDirector to output the final concrete Enemy object.");
        System.out.println("4. Prototype: Used deep-copy 'clone()' inside EnemyRegistry to spawn custom variants (like Elite Goblin) without re-running the Builder.");
        // TODO: Print a summary showing which patterns were demonstrated
        // Example:
        // System.out.println("Abstract Factory: Themed component families (Fire, Ice, Shadow)");
        // System.out.println("Builder: Complex step-by-step enemy construction");
        // System.out.println("Factory Method: Embedded in Builder.build() and Director");
        // System.out.println("Prototype: Efficient template cloning with deep copy");

        System.out.println("\n=== Demo Complete ===");
    }

    // TODO: Add helper methods as needed
    // Consider:
    // - displayEnemyDetails(Enemy enemy)
    // - demonstrateDeepCopy(Enemy original, Enemy clone)
    // - createThemeDemo(EnemyComponentFactory factory, String themeName)

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
