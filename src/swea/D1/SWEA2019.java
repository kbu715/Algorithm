package com.day6;

import java.util.Scanner;

public class SWEA2019 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		int N = sc.nextInt();
		
		for (int i = 0; i <= N; i++) {
			
			sb.append((int)(Math.pow(2, i)) + " ");
		}
		
		System.out.println(sb.toString());
	}

}
