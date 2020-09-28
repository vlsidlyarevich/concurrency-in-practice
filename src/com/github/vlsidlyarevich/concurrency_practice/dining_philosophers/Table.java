package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import java.util.LinkedHashMap;
import java.util.Map;

public class Table {

    private final Map<Philosopher, Pair<Fork, Fork>> philosophersForks = new LinkedHashMap<>();

    public void addPhilosopher(final Philosopher philosopher, boolean isLast) throws IllegalStateException {
        if (philosophersForks.isEmpty()) {
            addFirst(philosopher);
        } else if (!isLast) {
            addNotLast(philosopher);
        } else {
            addLast(philosopher);
        }
    }

    private void addFirst(final Philosopher philosopher) {
        this.philosophersForks.put(philosopher, Pair.of(new Fork(1), new Fork(2)));
    }

    private void addNotLast(final Philosopher philosopher) {

    }

    private void addLast(final Philosopher philosopher) {

    }

    private Pair<Philosopher, Pair<Fork, Fork>> getLastAddedPhilosopher() {
        if (philosophersForks.isEmpty()) throw new IllegalStateException();

        Map.Entry<Philosopher, Pair<Fork, Fork>> entry = (Map.Entry<Philosopher, Pair<Fork, Fork>>) philosophersForks
                .entrySet()
                .toArray()[philosophersForks.size() - 1];

        return Pair.of(entry.getKey(), entry.getValue());
    }
}
