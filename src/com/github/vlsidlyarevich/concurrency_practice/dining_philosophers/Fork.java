package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

public class Fork {

    private Philosopher owner = null;
    private final int number;

    public Fork(final int number) {
        this.number = number;
    }

    public Philosopher getOwner() {
        return owner;
    }

    public int getNumber() {
        return number;
    }
}
