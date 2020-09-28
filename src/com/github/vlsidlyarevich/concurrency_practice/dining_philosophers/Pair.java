package com.github.vlsidlyarevich.concurrency_practice.dining_philosophers;

public class Pair<L, R> {

    private final L left;
    private final R right;

    private Pair(final L left, final R right) {
        this.left = left;
        this.right = right;
    }

    public static <L, R> Pair<L, R> of(final L left, final R right) {
        return new Pair<>(left, right);
    }
}
