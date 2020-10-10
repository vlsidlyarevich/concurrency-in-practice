package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import java.util.Objects;

public class Philosopher extends Thread {

    private Table table;
    private Boolean isEating;
    private int eatenCount;
    private String philosopherName;

    public Philosopher(final String name) {
        super(name);
        this.philosopherName = name;
    }

    @Override
    public void run() {
        System.out.println("KEKS:" + this.getPhilosopherName());
    }

    public int getEatenCount() {
        return eatenCount;
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
