package com.day2;

import java.util.Scanner;

// 달팽이 숫자 

public class SWEA1954 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		// 우 하 좌 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int[] test_case = new int[T];

		// N 입력
		for (int i = 0; i < T; i++) {
			test_case[i] = sc.nextInt();
		}

		// 달팽이 숫자가 들어갈 배열
		int[][] numberArray;

		// 출력
		for (int i = 0; i < T; i++) {

			// 1. 빈방 만들고
			int N = test_case[i];
			numberArray = new int[N][N];

			// 2. 숫자 집어넣기

			int cnt = 1; // 계속 증가시킬 변수

			int direction = 0; // 우 -> 하 -> 좌 -> 상

			int x = 0;
			int y = 0;

			int nx = 0; // newIndex x
			int ny = 0; // newIndex y
			while (cnt <= N * N) {

				numberArray[nx][ny] = cnt;

				x = nx;
				y = ny;

				nx = x + dx[direction];
				ny = y + dy[direction];

				// 방향 전환 되는 상황 - 배열범위 초과 or 값이 들어간 곳을 만나면
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || numberArray[nx][ny] != 0) {
					// 구현해야함
					direction = ++direction % 4;
					nx = x + dx[direction];
					ny = y + dy[direction];
				}

				cnt++;

			}

			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					System.out.print(numberArray[j][j2]);
				}
				System.out.println();
			}

		}
	}

}
