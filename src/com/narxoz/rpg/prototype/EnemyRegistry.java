package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.HashMap;
import java.util.Map;

public class EnemyRegistry {
    private Map<String, Enemy> templates = new HashMap<>();
    public void registerTemplate(String key, Enemy template) {
        templates.put(key, template);
        System.out.println("Registered template: " + key);
    }
    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) {
            throw new IllegalArgumentException("Unknown template key: " + key);
        }
        return template.clone();
    }
    public void listTemplates() {
        System.out.println("Available Enemy Templates:");
        if (templates.isEmpty()) {
            System.out.println("  [Registry is empty]");
        } else {
            for (String key : templates.keySet()) {
                System.out.println("  - " + key);
            }
        }
    }
}
