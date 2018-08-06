package com.tkd.java;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterserviceFixedThreadPoolTest {

	public static void main(String[] args) {
		Runnable r1 = new Task("Task 1");
		Runnable r2 = new Task("Task 2");
		Runnable r3 = new Task("Task 3");
		Runnable r4 = new Task("Task 4");
		Runnable r5 = new Task("Task 5");
		
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		pool.execute(r1);
		pool.execute(r2);
		pool.execute(r3);
		pool.execute(r4);
		pool.execute(r5);
		pool.shutdown();
	}

}

class Task implements Runnable {
	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; i <= 5; i++) {
				if (i == 0) {
					LocalDateTime date = LocalDateTime.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
					System.out.println("Initialization Time for tast: " + name + " =" + format.format(date));
				} else {
					LocalDateTime date = LocalDateTime.now();
					DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm:ss");
					System.out.println("Executing Time for tast: " + name + " =" + format.format(date));
				}
				Thread.sleep(1000);
			}
			System.out.println(name + " Complete");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
