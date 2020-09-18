package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, 3, "Producer");
        Consumer consumer1 = new Consumer(queue, "Consumer 1");
//        Consumer consumer2 = new Consumer(queue, "Consumer 2");
        producer.start();
        consumer1.start();
        producer.join();
        consumer1.join();
        System.out.println("END");
    }
}
