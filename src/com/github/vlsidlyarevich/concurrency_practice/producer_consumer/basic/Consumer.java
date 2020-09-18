package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.Queue;

class Consumer extends Thread {

    private final Queue<Integer> queue;

    Consumer(final Queue<Integer> queue, final String threadName) {
        super(threadName);
        if (queue == null)
            throw new IllegalArgumentException("Cannot construct instance of Consumer: queue cannot be null");
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (queue) {
            Thread.sleep(500);
            if (queue.isEmpty() && producerState.isRunning()) {
                System.out.printf("%s idle%n", this.getName());
                queue.notifyAll();
                queue.wait();
            } else {
                System.out.printf("%s: Consuming value: %d%n", this.getName(), queue.poll());
            }
        }
    }
}
