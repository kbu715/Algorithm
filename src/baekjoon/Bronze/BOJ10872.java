package com.day1;

import java.util.Scanner;
// factorial
public class BOJ10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 첫째 줄에 정수 N(0 ≤ N ≤ 12)가 주어진다.

		if (N < 0 || N > 12) {
			return;
		}

		System.out.println(fac(N));

	}

	private static int fac(int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * fac(num - 1);
		}

	}

}
