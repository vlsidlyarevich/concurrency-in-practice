package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher;

public class ResourcePriorityAwarePhilosopher extends Philosopher {

    private final Boolean isFirst;

    public ResourcePriorityAwarePhilosopher(final String name, final Boolean isFirst) {
        super(name);
        this.isFirst = isFirst;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            if (isFirst) {
                this.table.takeLeftFork(this);
                this.table.takeRightFork(this);

                eat();
                think();

                this.table.releaseLeftFork(this);
                this.table.releaseRightFork(this);
            } else {
                this.table.takeRightFork(this);
                this.table.takeLeftFork(this);

                eat();
                think();

                this.table.releaseRightFork(this);
                this.table.releaseLeftFork(this);
            }
        }
    }
}
