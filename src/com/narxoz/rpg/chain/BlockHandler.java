package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public class BlockHandler extends DefenseHandler {
    private final double blockPercent;

    public BlockHandler(double blockPercent) {
        this.blockPercent = blockPercent;
    }


    @Override
    public void handle(int incomingDamage, ArenaFighter target) {
        // TODO: Calculate how much damage is blocked: (int)(incomingDamage * blockPercent).
        // TODO: Subtract the blocked amount from incomingDamage to get the remainder.
        // TODO: Print a block message showing how much was blocked.
        // TODO: Always pass the remainder to the next handler (block reduces but never stops the chain).
        // Design question: what should happen if the remainder reaches 0 or below?
        int reducedDamage = (int) (incomingDamage *(1.0 - blockPercent));
        System.out.println("Block reduced damage to "+ reducedDamage);
        passToNext(reducedDamage, target);
    }
}
