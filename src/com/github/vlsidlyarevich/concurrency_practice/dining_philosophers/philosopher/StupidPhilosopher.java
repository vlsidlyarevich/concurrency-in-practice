package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher;

public class StupidPhilosopher extends Philosopher {

    public StupidPhilosopher(final String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            this.table.takeLeftFork(this);
            this.table.takeRightFork(this);
            eat();
            think();
            this.table.releaseLeftFork(this);
            this.table.releaseRightFork(this);
        }
    }
}
