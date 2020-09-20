package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.consumer;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.buffer.Buffer;

import java.util.function.BooleanSupplier;

class Consumer<T> extends Thread {

    private final Buffer<T> buffer;
    private BooleanSupplier isRunning;

    Consumer(final Buffer<T> buffer, final BooleanSupplier isRunning) {
        if (buffer == null || isRunning == null)
            throw new IllegalArgumentException("Cannot construct consumer instance");
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (isRunning.getAsBoolean()) {
            consume();
        }

        System.out.printf("---------End of %s job---------%n", this.getName());
    }

    private void consume() {
        System.out.printf("%s: Consuming value: %d%n", this.getName(), buffer.get());
    }
}
