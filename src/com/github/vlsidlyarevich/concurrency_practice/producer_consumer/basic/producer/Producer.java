package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic.producer;

import java.util.Arrays;
import java.util.Queue;

public class Producer extends Thread {

    private final Queue<Integer> queue;
    private final int maxSize;
    private final int cyclesCount;

    private final ProducerState producerState = new ProducerState();

    public Producer(final Queue<Integer> queue, final int maxSize, final String threadName) {
        super(threadName);
        if (queue == null || maxSize <= 0) throw new IllegalArgumentException("Cannot construct instance of Producer");
        this.queue = queue;
        this.maxSize = maxSize;
    }

    public ProducerState getProducerState() {
        return producerState;
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
                System.out.printf("%s idle%n", this.getName());
                queue.notifyAll();
                queue.wait();
            }
        }
    }

    public class ProducerState {

        private volatile boolean isRunning = true;

        void stop() {
            this.isRunning = false;
        }

        public boolean isRunning() {
            return isRunning;
        }
    }
}


