package com.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 회문1 D3
public class SWEA1215 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int answer = 0;

			int N = Integer.parseInt(br.readLine());

			String[][] map = new String[8][8];

			for (int i = 0; i < 8; i++) {
				map[i] = br.readLine().split("");

			}
			boolean flag;

			// 가로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (j + k >= 8 || j + N - 1 - k >= 8) {
							flag = false;
							break;
						}
						if (!map[i][j + k].equals(map[i][j + N - 1 - k])) {
							flag = false;
						}
					}
					if (flag) {
						answer++;
					}
				}

			}

			// 세로
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					flag = true;
					for (int k = 0; k < N / 2; k++) {
						if (i + k >= 8 || i + N - 1 - k >= 8) {
							flag = false;
							break;
						}
						if (!map[i + k][j].equals(map[i + N - 1 - k][j])) {
							flag = false;
						}
					}
					if (flag) {
						answer++;
					}
				}

			}

			System.out.println("#" + tc + " " + answer);
		}
	}

}
