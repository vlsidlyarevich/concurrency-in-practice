package com.github.vlsidlyarevich.concurrency_practice.thread_states;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String object = "object";

        Thread thread = new Thread(() -> {
            System.out.printf("Hello!, my state is %s%n", Thread.currentThread().getState());

            try {
                Thread.sleep(2000);
                synchronized (object) {
                    object.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //NEW
        System.out.printf("Thread state: %s%n", thread.getState());

        //RUNNABLE
        thread.start();

        //TIMED_WAITING
        Thread.sleep(500);
        System.out.printf("Thread state: %s%n", thread.getState());


        //WAITING
        Thread.sleep(2000);
        System.out.printf("Thread state: %s%n", thread.getState());

        synchronized (object) {
            object.notifyAll();
        }

        thread.join();

        //TERMINATED
        System.out.printf("Thread state: %s%n", thread.getState());
    }
}
