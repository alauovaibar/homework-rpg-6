package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class ArmorHandler extends DefenseHandler {
    private final int armorValue;

    public ArmorHandler(int armorValue) {
        this.armorValue = armorValue;
    }


    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        // TODO: Subtract armorValue from incomingDamage; clamp the result to a minimum of 0.
        // TODO: Print an armor message showing how much was absorbed.
        // TODO: Pass the remaining damage to the next handler.
        int remainder = Math.max(0, incomingDamage - armorValue);
        System.out.println("Armor absorbed damage, remainder is " + remainder);
        passToNext(remainder,target);
    }
}
