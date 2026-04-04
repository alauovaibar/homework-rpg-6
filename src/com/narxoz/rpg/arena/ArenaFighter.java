package com.narxoz.rpg.arena;

public class ArenaFighter {
    private final String name;
    private int health;
    private final int maxHealth;
    private double dodgeChance;
    private final int blockRating;
    private final int armorValue;
    private final int attackPower;
    private int healPotions;

    public ArenaFighter(String name, int health, double dodgeChance,
                        int blockRating, int armorValue, int attackPower, int healPotions) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.dodgeChance = dodgeChance;
        this.blockRating = blockRating;
        this.armorValue = armorValue;
        this.attackPower = attackPower;
        this.healPotions = healPotions;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public double getDodgeChance() { return dodgeChance; }
    public int getBlockRating() { return blockRating; }
    public int getArmorValue() { return armorValue; }
    public int getAttackPower() { return attackPower; }
    public int getHealPotions() { return healPotions; }


    public void takeDamage(int amount) {
        // TODO: Reduce health by amount; clamp health to a minimum of 0.
        health -= amount;
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        // TODO: Increase health by amount; do not exceed maxHealth.
        // TODO: Decide what happens when healPotions runs out — should healing be blocked?
        health += amount;
        healPotions--;
        if (healPotions > 0 && health < maxHealth) {
            health = Math.min(maxHealth, health + amount);
            healPotions--;
            System.out.println(name + " Used a potion. Remaining: " + healPotions);
        } else if (healPotions <= 0) {
            System.out.println(name + " tried to heal but has no potions left!");
        }
    }

    public void modifyDodgeChance(double delta) {
        // TODO: Add delta to dodgeChance.
        // TODO: Decide whether to clamp dodgeChance between 0.0 and 1.0.
        dodgeChance += delta;
        dodgeChance = Math.min(1.0, Math.max(0.0, dodgeChance + delta));
    }

    public boolean isAlive() {
        // TODO: Return whether the fighter still has health remaining.
        return health > 0;
    }
}

