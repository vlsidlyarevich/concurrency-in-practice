package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.Philosopher;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();
        Philosopher diogenes = new Philosopher("Diogenes");
        Philosopher aquinas = new Philosopher("Aquinas");
        Philosopher bacon = new Philosopher("Bacon");
        Philosopher emerson = new Philosopher("Emerson");
        Philosopher chomsky = new Philosopher("Chomsky");

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
        table.visualiseStats();
    }
}
