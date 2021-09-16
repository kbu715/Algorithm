package com.day3;

import java.util.Scanner;
//D3
public class SWEA3307 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			} // 입력
			
			int[] LIS = new int[N]; // Longest Increasing Subsequence 14002 14003
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				
				for (int j = 0; j < i; j++) {
					if(arr[j] < arr[i] && LIS[j] + 1 > LIS[i]) {
						LIS[i] = LIS[j] + 1;
						if(max < LIS[i]) {
							max = LIS[i];
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+max);
			
		}
		sc.close();
	}

}
