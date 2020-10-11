package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.Philosopher;
import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.StupidPhilosopher;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Table table = new Table();
        Philosopher diogenes = new StupidPhilosopher("Diogenes");
        Philosopher aquinas = new StupidPhilosopher("Aquinas");
        Philosopher bacon = new StupidPhilosopher("Bacon");
        Philosopher emerson = new StupidPhilosopher("Emerson");
        Philosopher chomsky = new StupidPhilosopher("Chomsky");
//        Philosopher chomsky = new ResourcePriorityAwarePhilosopher("Chomsky", true);

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
        while (true) {
            Thread.sleep(1000);
            table.visualiseStats();
        }
    }
}
