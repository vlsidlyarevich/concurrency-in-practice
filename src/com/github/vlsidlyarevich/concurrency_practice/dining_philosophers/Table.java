package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.Philosopher;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {

    private final Map<Philosopher, Pair<Fork, Fork>> philosophersForks = new LinkedHashMap<>();

    public void addPhilosopher(final Philosopher philosopher, boolean isLast) throws IllegalStateException {
        philosopher.setTable(this);
        if (philosophersForks.isEmpty()) {
            addFirst(philosopher);
        } else if (!isLast) {
            addNotLast(philosopher);
        } else {
            addLast(philosopher);
        }
    }

    public void visualiseStats() {
        System.out.println("---Visualising stats---");
        philosophersForks.forEach((philosopher, forksPair)
                -> System.out.printf("Philosopher:%s has eated %d times%n", philosopher.getName(), philosopher.getEatenCount()));
        System.out.println("---Stats end---");
    }

    public void takeLeftFork(Philosopher caller) {
        this.philosophersForks.get(caller).getLeft().get(caller);
    }

    public void takeRightFork(Philosopher caller) {
        this.philosophersForks.get(caller).getRight().get(caller);
    }

    public void releaseLeftFork(Philosopher caller) {
        this.philosophersForks.get(caller).getLeft().release();
    }

    public void releaseRightFork(Philosopher caller) {
        this.philosophersForks.get(caller).getRight().release();
    }

    private void addFirst(final Philosopher philosopher) {
        this.philosophersForks.put(philosopher, Pair.of(new Fork(1), new Fork(2)));
    }

    private void addNotLast(final Philosopher philosopher) {
        Pair<Philosopher, Pair<Fork, Fork>> lastAdded = getLastAddedPhilosopher();
        int nextForkNumber = lastAdded.getRight().getLeft().getNumber() + 1;
        this.philosophersForks.put(philosopher, Pair.of(new Fork(nextForkNumber), lastAdded.getRight().getLeft()));
    }

    private void addLast(final Philosopher philosopher) {
        Pair<Philosopher, Pair<Fork, Fork>> firstAdded = getFirstAddedPhilosopher();
        Pair<Philosopher, Pair<Fork, Fork>> lastAdded = getLastAddedPhilosopher();
        this.philosophersForks.put(philosopher, Pair.of(firstAdded.getRight().getRight(), lastAdded.getRight().getLeft()));
    }

    private Pair<Philosopher, Pair<Fork, Fork>> getLastAddedPhilosopher() {
        if (philosophersForks.isEmpty()) throw new IllegalStateException();

        Map.Entry<Philosopher, Pair<Fork, Fork>> entry = (Map.Entry<Philosopher, Pair<Fork, Fork>>) philosophersForks
                .entrySet()
                .toArray()[philosophersForks.size() - 1];

        return Pair.of(entry.getKey(), entry.getValue());
    }

    private Pair<Philosopher, Pair<Fork, Fork>> getFirstAddedPhilosopher() {
        if (philosophersForks.isEmpty()) throw new IllegalStateException();

        Map.Entry<Philosopher, Pair<Fork, Fork>> entry = (Map.Entry<Philosopher, Pair<Fork, Fork>>) philosophersForks
                .entrySet()
                .toArray()[0];

        return Pair.of(entry.getKey(), entry.getValue());
    }
}
