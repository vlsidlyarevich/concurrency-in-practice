package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher;

public class ResourcePriorityAwarePhilosopher extends Philosopher {

    private final Boolean isLast;

    public ResourcePriorityAwarePhilosopher(final String name, final Boolean isLast) {
        super(name);
        this.isLast = isLast;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if(isLast) {
                this.table.takeRightFork(this);
                this.table.takeLeftFork(this);
            }

            this.table.takeLeftFork(this);
            this.table.takeRightFork(this);

            eat();
            think();

            if(isLast) {
                this.table.releaseRightFork(this);
                this.table.releaseLeftFork(this);
            }

            this.table.releaseLeftFork(this);
            this.table.releaseRightFork(this);
        }
    }
}
