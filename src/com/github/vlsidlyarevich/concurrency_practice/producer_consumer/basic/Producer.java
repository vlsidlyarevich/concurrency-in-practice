package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.Arrays;
import java.util.Queue;

class Producer extends Thread {

    private final Queue<Integer> queue;
    private final int maxSize;

    public Producer(final Queue<Integer> queue, final int maxSize, final String threadName) {
        super(threadName);
        if (queue == null || maxSize <= 0) throw new IllegalArgumentException("Cannot construct instance of Producer");
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        int startingValue = 0;
        while (true) {
            try {
                produce(startingValue++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int startingValue) throws InterruptedException {
        synchronized (queue) {
            Thread.sleep(500);
            if (queue.size() <= maxSize) {
                System.out.printf("%s: Producing value: %d%n", this.getName(), startingValue++);
                queue.add(startingValue);
                System.out.println(Arrays.toString(queue.toArray()));
            } else {
                System.out.println("Producer idle");
                queue.notifyAll();
                queue.wait();
            }
        }
    }
}
