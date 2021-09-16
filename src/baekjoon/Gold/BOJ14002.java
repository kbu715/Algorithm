package com.day3;

import java.util.Scanner;
import java.util.Stack;
//골드4
public class BOJ14002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] LIS = new int[N+1];
		
		int max = 0;
		for (int i = 1; i <= N; i++) {
			LIS[i] = 1;
			
			for (int j = 0; j < i; j++) {
				// 뒤쪽 숫자가 앞쪽 숫자보다 크고 
				if(arr[i] > arr[j] && LIS[j] + 1 > LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
			max = Math.max(max, LIS[i]);
			
		}
		//lis 구성 찾아서 출력
		int value = max;
		Stack<Integer> st = new Stack<>();
		for (int i = N; i >= 1; i--) {
			if(value == LIS[i]) {
				st.push(arr[i]);
				value--;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty()) {
			sb.append(st.pop() + " ");
		}
		
		System.out.println(max);
		System.out.println(sb.toString());
	
	}

}
