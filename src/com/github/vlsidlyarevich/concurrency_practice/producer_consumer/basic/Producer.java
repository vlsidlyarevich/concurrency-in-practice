package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.Queue;

class Producer extends Thread {

    private final Queue<Integer> queue;
    private final int maxSize;

    public Producer(final Queue<Integer> queue, int maxSize) {
        if (queue == null || maxSize <= 0) throw new IllegalArgumentException("Cannot construct instance of Producer");
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int startingValue = 0;
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (queue.size() <= maxSize) {
                System.out.printf("Producing value: %d%n", startingValue++);
                queue.add(startingValue);
            } else System.out.println("Producer idle");
        }
    }
}
