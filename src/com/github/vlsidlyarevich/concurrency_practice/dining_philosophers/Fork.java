package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher.Philosopher;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fork {

    private Philosopher owner = null;
    private final int number;

    private Lock lock = new ReentrantLock();

    public Fork(final int number) {
        this.number = number;
    }

    public boolean get(Philosopher owner) {
        this.lock.lock();
        this.owner = owner;
        return true;
    }

    public void release() {
        this.lock.unlock();
        this.owner = null;
    }

    public int getNumber() {
        return number;
    }
}
