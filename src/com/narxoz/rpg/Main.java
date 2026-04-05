package com.narxoz.rpg;

import com.narxoz.rpg.arena.ArenaFighter;
import com.narxoz.rpg.arena.ArenaOpponent;
import com.narxoz.rpg.arena.TournamentResult;
import com.narxoz.rpg.chain.*;
import com.narxoz.rpg.command.*;
import com.narxoz.rpg.tournament.TournamentEngine;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 6 Demo: Chain of Responsibility + Command ===\n");


        ArenaFighter hero = new ArenaFighter("Suleiman Zharas", 150, 0.15, 30, 10, 25, 5);
        ArenaOpponent opponent = new ArenaOpponent("The Iron Knight", 180, 20);

        // -----------------------------------------------------------------------
        // Part 1 — Command Queue Demo
        // -----------------------------------------------------------------------
        System.out.println("--- 1. Command Queue Demo ---");
        ActionQueue queue = new ActionQueue();


        queue.enqueue(new AttackCommand(opponent, hero.getAttackPower()));
        queue.enqueue(new HealCommand(hero, 20));
        queue.enqueue(new DefendCommand(hero, 0.15));

        System.out.println("Queued actions:");
        queue.getCommandDescriptions().forEach(d -> System.out.println("  - " + d));


        System.out.println("\nUndoing last action (Defend)...");
        queue.undoLast();

        System.out.println("Queue after undo:");
        queue.getCommandDescriptions().forEach(d -> System.out.println("  - " + d));

        // Выполнение
        System.out.println("\nExecuting commands...");
        queue.executeAll();
        System.out.println("Queue cleared: " + queue.getCommandDescriptions().isEmpty());

        // -----------------------------------------------------------------------
        // Part 2 — Defense Chain Demo
        // -----------------------------------------------------------------------
        System.out.println("\n--- 2. Defense Chain Demo ---");
        DefenseHandler dodge = new DodgeHandler(0.30, 12345L);
        DefenseHandler block = new BlockHandler(0.50);
        DefenseHandler armor = new ArmorHandler(5);
        DefenseHandler hp    = new HpHandler();


        dodge.setNext(block).setNext(armor).setNext(hp);

        System.out.println("Hero HP before 30 damage: " + hero.getHealth());
        dodge.handle(30, hero);
        System.out.println("Hero HP after: " + hero.getHealth());

        // -----------------------------------------------------------------------
        // Part 3 — Full Tournament Demo
        // -----------------------------------------------------------------------
        System.out.println("\n--- 3. Full Arena Tournament ---");


        TournamentEngine engine = new TournamentEngine(hero, opponent);


        TournamentResult result = engine.runTournament();

        System.out.println("\nTOURNAMENT RESULTS:");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Total Rounds: " + result.getRounds());
        System.out.println("\nFull Log:");

        result.getLog().forEach(line -> System.out.println("  " + line));

        System.out.println("\n=== Demo Complete ===");
    }
}