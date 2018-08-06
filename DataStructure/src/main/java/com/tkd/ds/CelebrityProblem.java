package com.tkd.ds;

import java.util.Scanner;

public class CelebrityProblem {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int noOftestCase = sc.nextInt();
		sc.nextLine();
		while(noOftestCase > 0) {
			int noOfCelebrityInParty = sc.nextInt();
			sc.nextLine();
			int[][] celebrityMatrix = new int[noOfCelebrityInParty][noOfCelebrityInParty];
			for (int i = 0; i < noOfCelebrityInParty; i++) {
				for (int j = 0; j < noOfCelebrityInParty; j++) {
					celebrityMatrix[i][j] = sc.nextInt();
				}
			}
			sc.nextLine();
			int strangeCelebrityID = -1;
			int counter = 0;
			for (int i = 0; i < noOfCelebrityInParty; i++) {
				for (int j = 0; j < noOfCelebrityInParty; j++) {
					if(i != j && celebrityMatrix[j][i] == 1) {
						counter++;
					} else if(i != j && celebrityMatrix[j][i] != 1) {
						break;
					}
				}
				if(counter == noOfCelebrityInParty -1) {
					strangeCelebrityID = i;
					break;
				}
				counter = 0;
			}
			
			System.out.println(strangeCelebrityID);
			
			noOftestCase --;
		}
		
		sc.close();
	}

}
