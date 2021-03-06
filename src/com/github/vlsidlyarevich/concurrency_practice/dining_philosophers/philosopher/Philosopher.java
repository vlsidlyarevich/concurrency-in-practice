package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.philosopher;

import com.github.vlsidlyarevich.concurrency_practice.dining_philosophers.Table;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher extends Thread {

    protected Table table;
    protected Boolean isEating;
    protected AtomicInteger eatenCount = new AtomicInteger(0);
    protected final String philosopherName;

    public Philosopher(final String name) {
        super(name);
        this.philosopherName = name;
    }

    @Override
    public void run() {
        System.out.println("KEKS:" + this.getPhilosopherName());
    }

    protected void eat() {
        this.eatenCount.addAndGet(1);
    }

    protected void think() {
        //
    }

    public int getEatenCount() {
        return eatenCount.get();
    }

    public String getPhilosopherName() {
        return this.philosopherName;
    }

    public void setTable(final Table table) {
        this.table = table;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Philosopher that = (Philosopher) o;
        return eatenCount == that.eatenCount &&
                Objects.equals(table, that.table) &&
                isEating.equals(that.isEating) &&
                philosopherName.equals(that.philosopherName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, isEating, eatenCount, philosopherName);
    }
}
