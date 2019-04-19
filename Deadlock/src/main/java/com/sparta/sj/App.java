package com.sparta.sj;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {
        final Deadlock deadlock = new Deadlock();

        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                deadlock.first();
            }
        };
        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                deadlock.second();
            }
        };

        Thread thread1 = new Thread(run1, "1st thread: ");
        thread1.start();

        Thread thread2 = new Thread(run2, "2nd thread: ");
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
