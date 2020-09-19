package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced;

import com.github.vlsidlyarevich.concurrency_practice.producer_consumer.advanced.producer.Producer;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int cycles = args.length > 0 ? Integer.parseInt(args[0]) : 0;

        Queue<Integer> queue = new LinkedList<>();

        Producer producer = new Producer(queue, 3, cycles, "Producer");
        Consumer consumer1 = new Consumer(queue, producer.getProducerState(), "Consumer 1");
        producer.start();
        consumer1.start();
        producer.join();
        consumer1.join();
        System.out.println("END");
    }
}
