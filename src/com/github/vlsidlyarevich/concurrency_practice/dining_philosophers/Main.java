package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

public class Main {

    public static void main(String[] args) {
        Table table = new Table();
        Philosopher diogenes = new Philosopher(table, "Diogenes");
        Philosopher aquinas = new Philosopher(table, "Aquinas");
        Philosopher bacon = new Philosopher(table, "Bacon");
        Philosopher emerson = new Philosopher(table, "Emerson");
        Philosopher chomsky = new Philosopher(table, "Chomsky");

    }
}
