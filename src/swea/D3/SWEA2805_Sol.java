package com.day3;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA2805_Sol {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input4.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // N값
			int[][] map = new int[N][N];
			int center = N / 2; // 중간 위치값

			// 입력
			for (int i = 0; i < N; i++) {
				char[] temp = sc.next().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = temp[j] - '0';
				}
			}

			int sum = 0, begin, end, gap = 0;
			for (int i = 0; i < N; i++) { // 행접근. 아래로 내려갈거임. begin-end 열의 값들을 수확

				begin = center - gap; // 한행의 시작 인덱스
				end = center + gap; // 한행의 끝 인덱스

				for (int j = begin; j <= end; j++) { // 열접근.
					sum += map[i][j];
				}

				if (i < center)
					gap++; // 중간보다 위쪽

				else
					gap--; // i >= center

			}
			// 출력
			System.out.println("#" + test_case + " " + sum);
		}
	}
}