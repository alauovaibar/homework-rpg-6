package com.narxoz.rpg.chain;

import com.narxoz.rpg.arena.ArenaFighter;

public abstract class DefenseHandler {
    private DefenseHandler next;

    public DefenseHandler setNext(DefenseHandler next) {
        // Provided: fluent setter so chains can be built like:
        //   dodge.setNext(block).setNext(armor).setNext(hp)
        // setNext returns the argument so the chain reads left-to-right.
        this.next = next;
        return next;
    }
    protected void getNext() {
    }


    public void passToNext(int damage, ArenaFighter target) {
        // TODO: If damage is still greater than 0 and a next handler exists, forward it.
        // TODO: What should happen when there is no next handler but damage is nonzero?
        if (next != null) {
            next.handle(damage, target);
        }
        }

    public void handle(int damage, ArenaFighter target) {
    }
}