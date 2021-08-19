package com.day2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 달팽이 숫자 

public class SWEA1954 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		// 우 하 좌 상
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			// 달팽이 숫자가 들어갈 배열
			int[][] numberArray = new int[N][N];

			int cnt = 1; // 계속 증가시킬 변수

			int direction = 0; // 우 -> 하 -> 좌 -> 상

			int x = 0;
			int y = 0;

			int nx = x;
			int ny = y;

			while (cnt <= N * N) {

				numberArray[nx][ny] = cnt++;

				x = nx;
				y = ny;

				nx = x + dx[direction];
				ny = y + dy[direction];

				// 방향 전환 되는 상황 - 배열범위 초과 or 값이 들어간 곳을 만나면
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || numberArray[nx][ny] != 0) {
					direction = ++direction % 4; // 방향전환
					nx = x + dx[direction];
					ny = y + dy[direction];
				}

			}
			sb.append("#" + tc + "\n");
			for (int j = 0; j < N; j++) {
				for (int j2 = 0; j2 < N; j2++) {
					sb.append(numberArray[j][j2] + " ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb);

	}
}
