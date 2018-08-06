package com.tkd.java;


public class DemoTests {
	static class A{
		void refundA() {
			
		}
	}
	static class B extends A{
		void refundB() {
			
		}
	}
	public static void main(String[] args) {
		B obj = new B();
		obj.refundA();
		obj.refundB();
		A obj1 = new B();
		obj1.refundA();
				
	}

}
