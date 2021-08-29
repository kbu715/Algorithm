package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1080 {
	static int[][] A;
	static int[][] B;
	static int N, M;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N][M];
		B = new int[N][M];

		// A input
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}

		// B input
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}

		if (N < 3 || M < 3) {
			if (isSame(A, B)) {
				answer = 0;
			} else {
				answer = -1;
			}
		} else {
			checkNreverse();
		}

		if (!isSame(A, B)) {
			answer = -1;
		}

		System.out.println(answer);
		sc.close();
	}

	private static void checkNreverse() {
		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					reverse(i, j);
					answer++;
				}
			}
		}
	}

	private static void reverse(int r, int c) {
		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				A[i][j] = A[i][j] ^ 1; // 비트 XOR 연산
			}
		}

	}

	private static boolean isSame(int[][] A, int[][] B) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j])
					return false;
			}
		}
		return true;
	}
}