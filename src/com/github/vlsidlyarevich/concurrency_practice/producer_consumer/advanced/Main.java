package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.buffer.Buffer;
import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.consumer.Consumer;
import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.producer.Producer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cycles = args.length > 0 ? Integer.parseInt(args[0]) : 0;

        Buffer<Integer> buffer = new Buffer<>(3);
        Producer producer = new Producer(cycles, "Producer", buffer);
        Consumer<Integer> consumer1 = new Consumer<>(buffer, producer::isRunning, "Consumer 1");
        Consumer<Integer> consumer2 = new Consumer<>(buffer, producer::isRunning, "Consumer 2");
        producer.start();
        consumer1.start();
        consumer2.start();
        producer.join();
        consumer1.join();
        consumer2.join();
        System.out.println("END");
    }
}
