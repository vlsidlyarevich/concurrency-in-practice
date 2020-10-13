package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.Philosopher;
import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.ResourcePriorityAwarePhilosopher;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();

        //Stupid philosophers leads to deadlock
//        Philosopher diogenes = new StupidPhilosopher("Diogenes");
//        Philosopher aquinas = new StupidPhilosopher("Aquinas");
//        Philosopher bacon = new StupidPhilosopher("Bacon");
//        Philosopher emerson = new StupidPhilosopher("Emerson");
//        Philosopher chomsky = new StupidPhilosopher("Chomsky");

        //Resource aware philosophers are trying to take bigger fork number first
        Philosopher diogenes = new ResourcePriorityAwarePhilosopher("Diogenes", true);
        Philosopher aquinas = new ResourcePriorityAwarePhilosopher("Aquinas", false);
        Philosopher bacon = new ResourcePriorityAwarePhilosopher("Bacon", false);
        Philosopher emerson = new ResourcePriorityAwarePhilosopher("Emerson", false);
        Philosopher chomsky = new ResourcePriorityAwarePhilosopher("Chomsky", false);

        table.addPhilosopher(diogenes, false);
        table.addPhilosopher(aquinas, false);
        table.addPhilosopher(bacon, false);
        table.addPhilosopher(emerson, false);
        table.addPhilosopher(chomsky, true);

        diogenes.start();
        aquinas.start();
        bacon.start();
        emerson.start();
        chomsky.start();

        diogenes.interrupt();
        aquinas.interrupt();
        bacon.interrupt();
        emerson.interrupt();
        chomsky.interrupt();

        table.visualiseStats();
    }
}
