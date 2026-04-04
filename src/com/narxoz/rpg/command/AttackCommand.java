package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaOpponent;

public class AttackCommand implements ActionCommand {
    private final ArenaOpponent target;
    private final int attackPower;
    private int damageDealt;

    public AttackCommand(ArenaOpponent target, int attackPower) {
        this.target = target;
        this.attackPower = attackPower;
    }


    @Override
    public void execute() {
        // TODO: Deal attackPower damage to the target using target.takeDamage(int).
        // TODO: Store the actual damage dealt in damageDealt so that undo() can reverse it exactly.
        // TODO: Consider: should damageDealt be capped at the target's remaining health?
        int hpBefore = target.getHealth();
        target.takeDamage(attackPower);
        this.damageDealt= hpBefore - target.getHealth();
    }

    @Override
    public void undo() {
        // TODO: Restore the stored damageDealt to the target using target.restoreHealth(int).
        // Note: Use damageDealt (what was actually applied), not attackPower.
        target.restoreHealth(damageDealt);
    }

    @Override
    public String getDescription() {
        // TODO: Return a readable summary, e.g. "Attack for 18 damage".
        return "Attack opponent for "+attackPower+" damage";
    }
}
