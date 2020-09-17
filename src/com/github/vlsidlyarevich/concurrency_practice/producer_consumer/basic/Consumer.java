package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.Arrays;
import java.util.Queue;

class Consumer extends Thread {

    private final Queue<Integer> queue;

    Consumer(final Queue<Integer> queue) {
        if (queue == null)
            throw new IllegalArgumentException("Cannot construct instance of Consumer: queue cannot be null");
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.printf("Consuming value: %d%n", queue.poll());
            System.out.println(Arrays.toString(queue.toArray()));
        }
    }
}
