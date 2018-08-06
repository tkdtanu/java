package com.tkd.java;

public class CustomSemaphoreDemo {
	static class CustomSemaphore{
		private int permits;

		public CustomSemaphore(int permits) {
			this.permits = permits;
		}
		
		public synchronized void release() {
			permits++;
			if(permits>0) {
				this.notifyAll();
			}
		}
		
		public synchronized void acquire() throws InterruptedException {
			if(permits > 0) {
				permits --;
			} else {
				this.wait();
				permits--;
			}
		}
		
	}

}
