package com.day8;

import java.util.Scanner;

// 배열 돌리기
public class BOJ16926 {
	// 우 하 좌 상 순
	static int[] dX = { 0, 1, 0, -1 };
	static int[] dY = { 1, 0, -1, 0 };
	static int N, M, R;
	static int[][] arr;

	private static void rotate(int depth) {
		for (int i = 0; i < depth; i++) {
			int sX = i;
			int sY = i;
			int d = 0;
			int tmp = arr[sX][sY];

			while (d < 4) {
				int nX = sX + dX[d];
				int nY = sY + dY[d];

				// 범위 내에 있으면 rotate
				if (nX >= i && nY >= i && nX < N - i && nY < M - i) {
					arr[sX][sY] = arr[nX][nY];
					sX = nX;
					sY = nY;
				} else {
					d++;
				}
			}

			// 마지막 처리
			arr[i + 1][i] = tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];

		// 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int depth = Math.min(N, M) / 2;

		for (int i = 0; i < R; i++) {
			rotate(depth);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}