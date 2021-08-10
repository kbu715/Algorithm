package com.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 파리 퇴치 
public class SWEA2001 {

	static int N;
	static int M;

	static int[][] map;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/fly.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new int[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 최대한 많은 파리를 죽이자
			int max = 0;
			for (int i = 0; i < N - M + 1; i++) {
				for (int j = 0; j < N - M + 1; j++) {

					if (max < getMaxFlies(i, j)) {
						max = getMaxFlies(i, j);
					}
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + max);

		}
	}

	// 최대로 많이 잡은 파리수를 반환한다.
	private static int getMaxFlies(int x, int y) {
		int sum = 0;
		for (int i = x; i < x + M; i++) {
			for (int j = y; j < y + M; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

}
