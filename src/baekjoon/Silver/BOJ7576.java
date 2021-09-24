package com.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 실버 1
public class BOJ7576 {

	static int N, M; // N: 세로 , M : 가로
	static Queue<int[]> list; // 익은 토마토 리스트
	static int[][] map;
	static int[][] howLong; // 익은지 얼마나 지났는지 담는다
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		howLong = new int[N][M];
		list = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) { // 익었으면
					list.add(new int[] { i, j }); // 익은 토마토 리스트에 담기
				}
			}
		}

		if (isAllRipen(map)) { // 처음부터 모두 익었으면
			answer = 0;
		} else {
			bfs();
			check();
		}

		System.out.println(answer);

	}

	private static void bfs() {

		while (!list.isEmpty()) {

			int[] cur = list.poll();
			int x = cur[0];
			int y = cur[1];

			for (int d = 0; d < 4; d++) { // 4방탐색
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
					list.add(new int[] { nx, ny });
					map[nx][ny] = 1;
					howLong[nx][ny] = howLong[x][y] + 1;
				}
			}
		}

	}

	private static boolean isAllRipen(int[][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void check() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {// 안익은 토마토가 존재하면
					answer = -1;
					return;
				}
				max = Math.max(max, howLong[i][j]);
			}
		}
		answer = max;
	}

}
