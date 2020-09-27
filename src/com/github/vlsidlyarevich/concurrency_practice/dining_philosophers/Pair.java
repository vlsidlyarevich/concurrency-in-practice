package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

public class Pair<T> {

    private final T left;
    private final T right;

    public Pair(final T left, final T right) {
        this.left = left;
        this.right = right;
    }
}
