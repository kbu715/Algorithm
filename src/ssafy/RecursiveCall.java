package com.day1;

public class RecursiveTest {

	public static void main(String[] args) {

		//반복문으로 구현
		for (int i = 0; i <= 4; i++) {
			System.out.println(i);
		}

		System.out.println("-------------------");

		// 재귀함수로 구현
		recur(0, 4, 1);

		// sum() : start, end 두개를 받아서 start ~ end까지의 합
		sum(1, 100);
	}

	private static void recur(int start, int end, int step) {
		// 1. 종료조건 (base part)
		if (start > end) {
			System.out.println("-------------------");
		}
		// 2. 반복조건
		else {
			System.out.println(start);
			recur(start + step, end, step); // 파라미터만 새로운 값으로 바꿔 자기자신을 호출
		}
	}

	private static int sum = 0;

	private static void sum(int start, int end) {

		if (start > end) {
			System.out.println("sum: " + sum);
			System.out.println("-------------------");
		} else {
			sum += start;
			sum(++start, end);
		}
	}

}
