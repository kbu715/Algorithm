package com.day5;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA1861 {

	static int N; // N*N
	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] rect; // 정사각형
	static int cnt; // route 수

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/rect.txt"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt(); // N*N

			rect = new int[N][N];

			// 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					rect[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			int maxNum = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cnt = 1; // 초기화, 왜 1이냐, 처음 시작하는 방은 카운트에 포함되기 때문에
					getMax(i, j);
					if (max < cnt) {
						max = cnt;
						maxNum = rect[i][j];
					} else if (max == cnt && maxNum > rect[i][j]) {
						maxNum = rect[i][j];
					}
				}
			}

			System.out.print("#" + test_case + " " + maxNum + " " + max);
			System.out.println();

		}
	}

	private static void getMax(int r, int c) {

		int nx = 0;
		int ny = 0;

		for (int d = 0; d < 4; d++) { // 상 하 좌 우 4번
			nx = r + dx[d];
			ny = c + dy[d];
			// 범위를 벗어나거나 차이가 1이 아니면
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || rect[nx][ny] != rect[r][c] + 1) {
				if (d == 3) { // 상 하 좌 우 4바퀴를 다 돌고 나면
					return;
				}
				continue;
			} else { // 차이가 1인 곳은 상 하 좌 우 중 하나뿐이므로
				cnt++;
				getMax(nx, ny);
			}
		}
	}
}