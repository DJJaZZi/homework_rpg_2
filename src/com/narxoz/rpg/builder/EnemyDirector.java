package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {
    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(EnemyBuilder builder) {
        this.builder = builder;
    }

    // FACTORY METHOD DELEGATION: The director does not know which concrete
    // enemy is being created. It calls builder.build() polymorphically.
    public Enemy createMinion(EnemyComponentFactory factory) {
        return builder
                .setName("Themed Minion")
                .setHealth(100)
                .setDamage(15)
                .setDefense(5)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        return builder
                .setName("Themed Elite")
                .setHealth(300)
                .setDamage(45)
                .setDefense(20)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Themed Mini-Boss")
                .setHealth(1500)
                .setDamage(100)
                .setDefense(60)
                .addPhase(1, 1500)
                .addPhase(2, 500) // Enrages at 500 HP
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Themed Raid Boss")
                .setHealth(10000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setCanFly(true)
                .setWingspan(40)
                .addPhase(1, 10000)
                .addPhase(2, 7000)
                .addPhase(3, 3000)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }
}
