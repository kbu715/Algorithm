package com.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// View D3 아파트 조망권확보 문제
public class SWEA1206 {

	static int N;
	static int[] dx = { -1, -2, 1, 2 };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 1; tc++) {
			N = Integer.parseInt(br.readLine());

			int[] buildings = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			answer = 0;
			check(buildings);

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void check(int[] buildings) {
		int[][] map = new int[255][N];

		for (int c = 0; c < N; c++) { // 열
			for (int r = 254; r > 254 - buildings[c]; r--) { // 행 // 아파트 높이
				map[r][c] = 1;
			}
		} // 지도 완성

		for (int r = 0; r < 255; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] == 1) {
					int localCnt = 0;
					for (int k = 0; k < 4; k++) { // 4칸 다 건물이 없어야 (즉, 1이 아니어야) 조망권확보
						int nc = c + dx[k];
						if (nc >= 0 && nc < N && map[r][nc] == 0) { // 옆에 건물이 없다.
							localCnt++;
						}
					}
					if (localCnt == 4) {
						answer++; // 조망권 확보 +1
					}
				}
			}
		}
	}

}
