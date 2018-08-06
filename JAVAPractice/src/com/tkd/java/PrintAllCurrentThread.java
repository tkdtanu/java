package com.tkd.java;

import java.util.Set;

public class PrintAllCurrentThread {

	static class DemoThread implements Runnable {
		boolean ready = false;
		boolean doJob = true;

		public void run() {
			String thrdName = Thread.currentThread().getName();

			startWait();
			System.out.println("wait stopped");
			doJob();
		}

		synchronized void startWait() {
			try {
				while (!ready)
					wait();
			} catch (InterruptedException exc) {
				System.out.println("wait() interrupted");
			}
		}

		synchronized void notice() {
			ready = true;
			notify();
		}
		
		synchronized void doJob() {
			System.out.println("doing job");
				if (doJob) {
					System.out.println(Thread.currentThread().getState());
				}
			
		}

		synchronized void noticeToStopJob() {
			this.doJob = false;
		}

	}

	public static void main(String args[]) throws Exception {
		DemoThread d1=new DemoThread();
		Thread thrd = new Thread(d1);
		thrd.setName("MyThread #1");
		showThreadStatus(thrd);

		thrd.start();
		showThreadStatus(thrd);
		Thread.sleep(50);
		showThreadStatus(thrd);


		d1.notice();
		showThreadStatus(thrd);
		Thread.sleep(1000);
		showThreadStatus(thrd);
		d1.noticeToStopJob();
		showThreadStatus(thrd);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Program is going to stop now");
				
			}
		}));
	}

	static void showThreadStatus(Thread thrd) {
		System.out.println(thrd.getName() +  " :" + thrd.getState());
	}

}
