package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.producer;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.buffer.Buffer;

import java.util.concurrent.atomic.AtomicBoolean;

public class Producer extends Thread {

    private final Buffer<Integer> buffer;
    private final int cyclesCount;

    private final AtomicBoolean isRunning = new AtomicBoolean();

    private static final int DEFAULT_CYCLES_COUNT = 10;

    public Producer(final int cyclesCount, final String threadName, final Buffer<Integer> buffer) {
        super(threadName);
        if (buffer == null) throw new IllegalArgumentException("Cannot construct producer instance");
        this.cyclesCount = cyclesCount > 0 ? cyclesCount : DEFAULT_CYCLES_COUNT;
        this.buffer = buffer;
    }

    public boolean isRunning() {
        return isRunning.get();
    }

    @Override
    public void run() {
        int startingValue = 0;
        int currentCycle = 0;
        this.isRunning.set(true);
        while (currentCycle < cyclesCount) {
            currentCycle++;
            try {
                produce(startingValue++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isRunning.set(false);
        System.out.printf("---------End of %s job---------%n", this.getName());
    }

    private void produce(int startingValue) throws InterruptedException {
        System.out.printf("%s: Producing value: %d%n", this.getName(), startingValue++);
        buffer.put(startingValue);
    }
}


