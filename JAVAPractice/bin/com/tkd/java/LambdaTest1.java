package com.example.demo;

import java.util.HashSet;
import java.util.Set;

public class LambdaTest1 {
    public static void main(String[] args) throws InterruptedException {
        String input = "Hello World";
        char[] ch = input.toCharArray();
        Set<Character> alreadyCoveredCharacter = new HashSet<>();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if(alreadyCoveredCharacter.contains(c)){
                continue;
            }

        }

        Runnable runnable = new MyRunnableA();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
    }
}

class MyRunnableA implements Runnable {
    private Integer current = 1;

    @Override
    public void run() {
        synchronized (this) {
            while (current <= 5) {
                System.out.println(Thread.currentThread().getName() + ":" + current);
                current++;
                this.notify();
                try {
                    if (current < 5) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
