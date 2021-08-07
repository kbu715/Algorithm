package com.memorize;

import java.util.Arrays;
import java.util.Scanner;

// nCr 

public class CombinationTest {

	// 1,2,3
	// 3C2 = 3!/1!2! = 3
	static int N, R; // N 개 중에서 R 개 // 순서가 의미가 없다
	static int[] input, selected;
	static int totalCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		input = new int[N];
		selected = new int[R]; // 뽑아야 되는 값들의 배열

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		combination(0, 0); // cnt, start
		System.out.println("총 경우의 수 : " + totalCount);
	}

	// cnt: 지금껏 뽑은 데이터 갯수, start: 전체 배열에서 뽑을 시작 위치
	private static void combination(int cnt, int start) {
		// 하나의 조합이 완성되면 화면에 출력하기
		if (cnt == R) { // basis // 종료조건 // 기저조건
			totalCount++;
			System.out.println(Arrays.toString(selected));
			return;
		}
		for (int i = start; i < N; ++i) {
			selected[cnt] = input[i];
			combination(cnt + 1, i + 1);
		}
	}
}
