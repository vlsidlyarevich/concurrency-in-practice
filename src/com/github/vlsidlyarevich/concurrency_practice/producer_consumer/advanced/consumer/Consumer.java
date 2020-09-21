package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.consumer;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.buffer.Buffer;

import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;

public class Consumer<T> extends Thread {

    private final Buffer<T> buffer;
    private final BooleanSupplier isRunning;

    public Consumer(final Buffer<T> buffer, final BooleanSupplier isRunning, String threadName) {
        super(threadName);
        if (buffer == null || isRunning == null)
            throw new IllegalArgumentException("Cannot construct consumer instance");
        this.buffer = buffer;
        this.isRunning = isRunning;
    }

    @Override
    public void run() {
        while (isRunning.getAsBoolean()) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                System.out.printf("%s: can't consume value: queue is empty!%n", this.getName());
            }
        }

        System.out.printf("---------End of %s job---------%n", this.getName());
    }

    private void consume() throws InterruptedException, NoSuchElementException {
//        Thread.sleep(200);
        System.out.printf("%s: Consuming value: %d%n", this.getName(), buffer.get());
    }
}
