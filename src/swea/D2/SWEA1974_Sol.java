package com.day9;

import java.util.HashSet;
import java.util.Scanner;

// 스도쿠 검사
public class SWEA1974_Sol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// tc입력
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 1. data 입력
			int[][] map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			} // 입력 끝

			// 입력 확인
//			System.out.println(Arrays.deepToString(map));

			int result = check(map);
			System.out.println("#" + tc + " " + result);
		}
	}

	private static int check(int[][] map) {
		HashSet<Integer> set = new HashSet<>(); // 중복안됨. 순서없음

		// 1. 가로 체크
		for (int i = 0; i < 9; i++) { // 행
			set.clear(); // 새로운 행이 시작될 때마다 비우기
			for (int j = 0; j < 9; j++) { // 열
				set.add(map[i][j]);
			}
			if (set.size() < 9) { // 데이터 갯수가 9보다 작으면 중복된 값이 존재한다.
				return 0;
			}
		}
		set.clear();

		// 2. 세로 체크
		for (int i = 0; i < 9; i++) { // 열
			set.clear(); // 새로운 열이 시작될 때마다 비우기
			for (int j = 0; j < 9; j++) { // 행
				set.add(map[j][i]);
			}
			if (set.size() < 9) { // 데이터 갯수가 9보다 작으면 중복된 값이 존재한다.
				return 0;
			}
		}
		set.clear();

		// 3. 작은 사각형 체크
		for (int i = 0; i < 3; i++) { // 큰사각형에서 봤을 때 행
			for (int j = 0; j < 3; j++) { // 큰사각형에서 봤을 때 열
				set.clear();
				for (int k = 0; k < 3; k++) { // 작은사각형에서 행
					for (int l = 0; l < 3; l++) { // 작은 사각형에서 열
						set.add(map[i * 3 + k][j * 3 + l]);
					}
				}
				if (set.size() < 9) {
					return 0;
				}
			}
		}
		set.clear();
		return 1;
	}

}
