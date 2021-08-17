package com.day11;

import java.util.Scanner;

// 거듭제곱 구하기
public class SquareNumber {
	static int callCnt;

	static long exp1(long x, long y) { // 재귀로 구현
		callCnt++;
		if (y == 1)
			return x;

		return x * exp1(x, y - 1);
	}

	// 분할정복으로 구현
	static long exp2(long x, long y) {
		callCnt++;
		if (y == 1)
			return x;

		long r = exp2(x, y / 2);
		long result = r * r;

		if (y % 2 == 1) {
			result *= x;
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();
		int y = sc.nextInt();

//		System.out.println(exp1(x, y));
		System.out.println(exp2(x, y)); 
		System.out.println(callCnt); // O(log 2 N)
	}

}
