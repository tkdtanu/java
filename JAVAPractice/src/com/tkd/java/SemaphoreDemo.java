package com.tkd.java;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

	public static void main(String[] args) throws InterruptedException {
		String abc= new String("abc");
		String newString = abc.intern();
		
		String abcd = "abc";
		System.out.println(abc == abcd);
		System.out.println(newString == abcd);
		System.out.println(abc.equals(abcd));
		Semaphore semaphore = new Semaphore(1);
		MyThread1 t1 = new MyThread1(semaphore, "A");
		MyThread2 t2 = new MyThread2(semaphore, "B");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Count value is " + Shared.count);
	}

}

class Shared {
	public static int count = 0;
}

class MyThread1 extends Thread {
	Semaphore semaphore;
	String name;

	public MyThread1(Semaphore semaphore, String name) {
		super(name);
		this.semaphore = semaphore;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			System.out.println("Thread " + name +" is wating for the lock");
			semaphore.acquire();
			System.out.println("Thread " + name + " got the lock");
			for (int i = 0; i < 5; i++) {
				System.out.println(Shared.count++);
				Thread.sleep(1000);
			}
			System.out.println("Thread " + name + " finised the work");
			System.out.println("Thread " + name + " released the lock");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class MyThread2 extends Thread {
	Semaphore semaphore;
	String name;

	public MyThread2(Semaphore semaphore, String name) {
		super(name);
		this.semaphore = semaphore;
		this.name = name;
	}
	public void run() {

		try {
			System.out.println("Thread " + name +" is wating for the lock");
			semaphore.acquire();
			System.out.println("Thread " + name + " got the lock");
			for (int i = 0; i < 5; i++) {
				System.out.println(Shared.count--);
				Thread.sleep(1000);
			}
			System.out.println("Thread " + name + " finised the work");
			System.out.println("Thread " + name + " released the lock");
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}