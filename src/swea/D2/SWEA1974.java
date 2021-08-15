package com.day9;

import java.util.Scanner;

public class SWEA1974 {

	static int sudoku[][]; // 9x9 스도쿠
	static boolean flag[]; // 1~9가 한 행, 한 열, 한 사각형 안에 하나씩만 존재하는지 여부를 저장한 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			sudoku = new int[9][9];
			boolean nextStep = true;

			// 입력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			}

			// 행
			for (int i = 0; i < 9; i++) {
				if (!checkRow(i)) {
					System.out.println("#" + tc + " " + 0);
					nextStep = false;
					break;
				}
			}

			if (!nextStep) // false이면 다음 테스트 케이스로 넘어간다.
				continue;

			// 열
			for (int i = 0; i < 9; i++) {
				if (!checkCol(i)) {
					System.out.println("#" + tc + " " + 0);
					nextStep = false;
					break;
				}
			}

			if (!nextStep)
				continue;

			// 3x3
			outside: for (int i = 0; i <= 6; i += 3) {
				for (int j = 0; j <= 6; j += 3) {
					if (!checkSquare(i, j)) {
						System.out.println("#" + tc + " " + 0);
						nextStep = false;
						break outside;
					}
				}
			}

			if (!nextStep)
				continue;
			// 모든 유효성 검사를 통과하면 1 출력
			System.out.println("#" + tc + " " + 1);
		}

		sc.close();
	}

	private static boolean checkRow(int i) {
		flag = new boolean[10]; // 인덱스 0은 쓰지 않는다. // flag[1]에서는 값 1의 중복검사를 한다.

		for (int j = 0; j < 9; j++) {
			if (flag[sudoku[i][j]]) { // true이면 이미 map[i][j]에 해당하는 값을 체크했음. 그럼 중복검사를 하게 되는 것
				return false;
			}
			flag[sudoku[i][j]] = true; // 처음 체크 하면 false -> true
		}
		return true;
	}

	private static boolean checkCol(int i) {
		flag = new boolean[10];

		for (int j = 0; j < 9; j++) {
			if (flag[sudoku[j][i]]) {
				return false;
			}
			flag[sudoku[j][i]] = true;
		}
		return true;
	}

	private static boolean checkSquare(int r, int c) {
		flag = new boolean[10];
		int r3 = r + 3; // 3x3
		int c3 = c + 3;

		for (int i = r; i < r3; i++) {
			for (int j = c; j < c3; j++) {
				if (flag[sudoku[i][j]]) {
					return false;
				}
				flag[sudoku[i][j]] = true;
			}
		}
		return true;
	}
}