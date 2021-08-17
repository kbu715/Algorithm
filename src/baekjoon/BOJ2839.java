package com.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int initialValue = N, currentValue = 0, totalValue = 0, countOfFive = 0, countOfThree = 0;
		int totalCount = 0;

		countOfFive = N / 5; // 최소값을 구해야하므로 일단 5로 나눠서 시작

		while (countOfFive >= 0) {
			currentValue = initialValue - countOfFive * 5; // 5로 나눠진 만큼 전체 값에서 빼주고
			countOfThree = currentValue / 3; // 3으로 나눈다
			totalValue = countOfFive * 5 + countOfThree * 3;

			if (initialValue - totalValue == 0) {
				totalCount = countOfFive + countOfThree;
				System.out.println(totalCount);
				break;
			}
			countOfFive--;
		}

		if (initialValue != totalValue) { // 최종적으로 두 값이 다르면 5 또는 3으로 나누어 떨어지지 않는다.
			System.out.println("-1"); // -1 리턴
		}
	}

}
