package com.narxoz.rpg.command;

import com.narxoz.rpg.arena.ArenaFighter;

public class DefendCommand implements ActionCommand {
    private final ArenaFighter target;
    private final double dodgeBoost;

    public DefendCommand(ArenaFighter target, double dodgeBoost) {
        this.target = target;
        this.dodgeBoost = dodgeBoost;
    }


    @Override
    public void execute() {
        // TODO: Apply the dodge boost using target.modifyDodgeChance(dodgeBoost).
        // TODO: This boost is temporary — it applies until the next incoming attack.
        //       For this assignment, the boost persists until undo() is called.
        target.modifyDodgeChance(dodgeBoost);
    }

    @Override
    public void undo() {
        // TODO: Remove the dodge boost by calling target.modifyDodgeChance(-dodgeBoost).
        // Note: This is most meaningful when the command is still queued and not yet executed.
        target.modifyDodgeChance(-dodgeBoost);
    }

    @Override
    public String getDescription() {
        // TODO: Return a readable summary, e.g. "Defend (dodge boost: +0.15)".

        return "Boost dodge chance by "+String.format("%.2f",dodgeBoost)+")";
    }
}
