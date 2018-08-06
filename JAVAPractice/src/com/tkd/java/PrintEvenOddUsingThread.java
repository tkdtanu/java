package com.tkd.java;

public class PrintEvenOddUsingThread {
	
	public static void main(String[] args) throws InterruptedException {
		EvenOddController controller = new EvenOddController(true, 1, 20);
		Thread t1 = new Thread(new EvenThreadPrinter(controller));
		Thread t2 = new Thread(new OddThreadPrinter(controller));
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
	
}

class EvenOddController {
	boolean odd;
	int start_number;
	int max_number;
	public EvenOddController(boolean odd, int start_number, int max_number) {
		this.odd = odd;
		this.start_number = start_number;
		this.max_number = max_number;
	}
	

}

class EvenThreadPrinter implements Runnable {
	private EvenOddController evenOddController;

	public EvenThreadPrinter(EvenOddController evenOddController) {
		this.evenOddController = evenOddController;
	}

	@Override
	public void run() {
		while (evenOddController.start_number != evenOddController.max_number) {
			synchronized (evenOddController) {
				if(!evenOddController.odd) {
					System.out.println(evenOddController.start_number);
					evenOddController.start_number++;
					evenOddController.odd = !evenOddController.odd;
				}else {
					evenOddController.notify();
				}
				if(evenOddController.start_number == evenOddController.max_number) {
					break;
				}
			}
		}
	}

}

class OddThreadPrinter implements Runnable {
	private EvenOddController evenOddController;

	public OddThreadPrinter(EvenOddController evenOddController) {
		this.evenOddController = evenOddController;
	}

	@Override
	public void run() {
		while (evenOddController.start_number != evenOddController.max_number) {
			synchronized (evenOddController) {
				if(evenOddController.odd) {
					System.out.println(evenOddController.start_number);
					evenOddController.start_number++;
					evenOddController.odd = !evenOddController.odd;
				}else {
					evenOddController.notify();
				}
				if(evenOddController.start_number == evenOddController.max_number) {
					break;
				}
			}
		}

	}

}
