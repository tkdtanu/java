package com.tkd.java;

import java.util.Arrays;

public class FindUnlockKey {

	public static void main(String[] args) {
		System.out.println(findUnlockKey(310));
		System.out.println(findUnlockKey(481));
		System.out.println(findUnlockKey(4000));
	}
	
	private static long findUnlockKey(long lockKey) {
		String lockKeystring = "";
		if(lockKey < 0) {
			lockKey = Math.abs(lockKey);
			lockKeystring = lockKey +"";
		}else {
			lockKeystring = lockKey + "";
		}
		
		char noArray[] = lockKeystring.toCharArray();
		Arrays.sort(noArray);
		if(noArray.length > 0 && (noArray[0]) == '0') {
			for (int i = 1; i < noArray.length; i++) {
				if(noArray[i] != '0') {
					char  temp = noArray[0];
					noArray[0] = noArray[i];
					noArray[i] = temp; 
					break;
				}
			}
		}
		return Long.parseLong(String.valueOf(noArray));
	}

}
