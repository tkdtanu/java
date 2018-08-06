package com.tkd.ds;


public class PrintLongestSubstring1 {

	public static void main(String[] args) {
		/*String str1= "abc";
		String str2 = new String("abc");
		String str3 = new String("abc");
		String str4 = "abc";
		
		System.out.println(str1 == str4);
		System.out.println(str2 == str3);
		System.out.println("str1 hascode: "+ System.identityHashCode(str1));
		System.out.println("str2 hascode: "+ System.identityHashCode(str2));
		System.out.println("str3 hascode: "+ System.identityHashCode(str3));
		System.out.println("str4 hascode: "+ System.identityHashCode(str4));
		*/
		abc a= new abc(10);
		a.so();

	}
	

}

interface xyz{
	int x= 20;
}
class abc implements xyz{
	int x=30;
	abc(int x) {
		this.x= x;
	}
	public void so() {
		System.out.println(this.x);
		System.out.println(xyz.x);
	}
}

