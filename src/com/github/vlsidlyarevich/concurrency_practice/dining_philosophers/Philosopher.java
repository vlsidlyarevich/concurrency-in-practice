package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

import java.util.Objects;

public class Philosopher {

    private final Table table;
    private final String name;
    private Boolean isEating;

    public Philosopher(final Table table, final String name) {
        this.table = table;
        this.name = name;
    }



    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Philosopher that = (Philosopher) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
