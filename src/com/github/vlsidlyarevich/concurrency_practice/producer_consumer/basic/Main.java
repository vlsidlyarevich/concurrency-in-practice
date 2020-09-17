package com.github.vlsidlyarevich.concurrency_practice.producer_consumer.basic;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Producer producer = new Producer(queue, 10);
        producer.start();
        Consumer consumer = new Consumer(queue);
        consumer.start();
    }
}
