package com.day6;

import java.util.*;
import java.io.*;

public class BOJ17144 {
	static int R, C, T;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer;

	static List<Integer> airPurifierRows = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {
					airPurifierRows.add(i);
				}
			}
		}

		for (int i = 0; i < T; i++) {
			// 1. 미세먼지 동시 확산 후 지도 리턴
			spread();

			// 2. 공기청정기 가동
			operate();
		}

		calcSum(); // 총 미세먼지 계산

		System.out.println(answer);

	}

	private static void spread() {
		int[][] temp = new int[R][C];

		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				if (map[x][y] == -1) {
					temp[x][y] = -1;
					continue;
				}

				temp[x][y] += map[x][y];

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
						if (map[nx][ny] >= 0) {
							temp[nx][ny] += (int) (map[x][y] / 5);
							temp[x][y] -= (int) (map[x][y] / 5);
						}
					}
				}
			}
		}

		map = temp;
	}

	private static void operate() {
		// 위쪽 반시계방향
		int topRow = airPurifierRows.get(0);

		for (int x = topRow - 1; x > 0; x--) {
			map[x][0] = map[x - 1][0];
		}

		for (int y = 0; y < C - 1; y++) {
			map[0][y] = map[0][y + 1];
		}

		for (int x = 0; x < topRow; x++) {
			map[x][C - 1] = map[x + 1][C - 1];
		}

		for (int y = C - 1; y > 1; y--) {
			map[topRow][y] = map[topRow][y - 1];
		}

		map[topRow][1] = 0;

		// 아래쪽 시계 방향
		int bottomRow = airPurifierRows.get(1);

		for (int x = bottomRow + 1; x < R - 1; x++) {
			map[x][0] = map[x + 1][0];
		}

		for (int y = 0; y < C - 1; y++) {
			map[R - 1][y] = map[R - 1][y + 1];
		}

		for (int x = R - 1; x > bottomRow; x--) {
			map[x][C - 1] = map[x - 1][C - 1];
		}

		for (int y = C - 1; y > 1; y--) {
			map[bottomRow][y] = map[bottomRow][y - 1];
		}

		map[bottomRow][1] = 0;
	}

	private static void calcSum() {
		int sum = 0;

		for (int x = 0; x < R; x++) {
			for (int y = 0; y < C; y++) {
				sum += map[x][y];
			}
		}
		answer = sum + 2; // -1 2개 제거
	}
}