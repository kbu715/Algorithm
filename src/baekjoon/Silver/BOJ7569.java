package com.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 실버 1
public class BOJ7569 {

	static int N, M, H;
	static Queue<int[]> list;
	static int[][][] map;
	static int[][][] howLong;
	// 상 하 좌 우 위 아래
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[N][M][H];
		howLong = new int[N][M][H];
		list = new LinkedList<>();

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j][k] = Integer.parseInt(st.nextToken());
					if (map[i][j][k] == 1) { // 익었으면
						list.add(new int[] { i, j, k }); // 익은 토마토 리스트에 담기
					}
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

	private static void check() {
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (map[i][j][k] == 0) {
						answer = -1;
						return;
					}
					max = Math.max(max, howLong[i][j][k]);
				}
			}
		}
		answer = max;
	}

	private static void bfs() {

		while (!list.isEmpty()) {

			int[] cur = list.poll();
			int x = cur[0];
			int y = cur[1];
			int z = cur[2];

			for (int d = 0; d < 6; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				int nz = z + dz[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H && map[nx][ny][nz] == 0) {
					list.add(new int[] { nx, ny, nz });
					map[nx][ny][nz] = 1;
					howLong[nx][ny][nz] = howLong[x][y][z] + 1;
				}
			}
		}

	}

	private static boolean isAllRipen(int[][][] map) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < H; k++) {
					if (map[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
