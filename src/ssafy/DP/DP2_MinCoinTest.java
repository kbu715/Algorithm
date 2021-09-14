package com.day1;

import java.util.Scanner;

public class DP2_MinCoinTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int money = sc.nextInt();
		
		int[] D = new int[money+1];
		
		D[0] = 0; // 명시적으로
		
		
		for (int i = 1; i <= money; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i>=1 && D[i-1]+1 < min) min = D[i-1] + 1;
			
			if(i>=2 && D[i-2]+1 < min) min = D[i-2] + 1;
			
			if(i>=5 && D[i-5]+1 < min) min = D[i-5] + 1;
			
			D[i] = min;
		}
		
		System.out.println(D[money]); // money원을 만드는 최적의 동전 수
		
		
	}

}
