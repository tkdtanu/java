package com.example.demo;

public class ThreadTestSharedRunnable {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new MyRunnableA();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(((MyRunnableA) runnable).getCount());

    }
}

class MyRunnable implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            this.count++;
        }
        System.out.println(this.count);
    }

    public int getCount() {
        return count;
    }
}
