package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic.producer.Producer;

import java.util.Queue;

class Consumer extends Thread {

    private final Queue<Integer> queue;

    private final Producer.ProducerState producerState;

    Consumer(final Queue<Integer> queue, final Producer.ProducerState producerState, final String threadName) {
        super(threadName);
        this.producerState = producerState;
        if (queue == null || producerState == null)
            throw new IllegalArgumentException("Cannot construct instance of Consumer");
        this.queue = queue;
    }

    @Override
    public void run() {
        while (producerState.isRunning()) {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("---------End of %s job---------%n", this.getName());
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
