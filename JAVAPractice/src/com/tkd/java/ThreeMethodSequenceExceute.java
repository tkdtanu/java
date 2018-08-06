package com.tkd.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreeMethodSequenceExceute {
	static class Methods{
		
		Semaphore s1= new Semaphore(1);
		Semaphore s2= new Semaphore(0);
		Semaphore s3= new Semaphore(0);
		
		
		public void m1() {
			System.out.println("executing m1");
			s2.release();
		}
		public void m2() {
			System.out.println("executing m2");
			s3.release();
		}
		public void m3() {
			System.out.println("executing m3");
			s1.release();
		}
	}
	static class M1Thread implements Runnable{
		{
			System.out.println("M1Thread");
		}
		private Methods methods;
		{
			System.out.println("M1Thread2");
		}
		public M1Thread(Methods methods) {
			this.methods = methods;
		}

		@Override
		public void run() {
			try {
				while(true) {
					methods.s1.acquire();
					methods.m1();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	static class M2Thread implements Runnable{
		{
			System.out.println("M2Thread");
		}
		private Methods methods;
		
		public M2Thread(Methods methods) {
			this.methods = methods;
		}
		
		{
			System.out.println("M2Thread2");
		}

		@Override
		public void run() {
			try {
				while(true) {
					methods.s2.acquire();
					methods.m2();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	static class M3Thread implements Runnable{
		{
			System.out.println("MyThread3");
		}
		private Methods methods;
		
		public M3Thread(Methods methods) {
			this.methods = methods;
		}
		{
			System.out.println("MyThread3");
		}
		@Override
		public void run() {
			try {
				while(true) {
					methods.s3.acquire();
					methods.m3();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Methods myMethods = new Methods();
		executorService.execute(new M1Thread(myMethods));
		executorService.execute(new M2Thread(myMethods));
		executorService.execute(new M3Thread(myMethods));
		executorService.shutdown();
	}

}
