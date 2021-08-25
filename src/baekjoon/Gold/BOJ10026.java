package com.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 골드 V 적록색약
public class BOJ10026 {

	static int N; // N x N;
	static int count; // 일반 구역 수
	static int rgCount; // 적록색약인 사람이 본 구역 수
	static char[][] map; // 일반지도
	static char[][] rgMap; // 적록색약인 사람이 보는 지도
	static boolean[][] visited; // 일반지도의 방문여부 기록
	static boolean[][] rgVisited; // 적록색약의 방문여부 기록
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		rgMap = new char[N][N];
		visited = new boolean[N][N];
		rgVisited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				// 적록색약인 사람이 보는 지도 데이터 바꿔주기
				rgMap[i][j] = map[i][j];
				if (map[i][j] == 'G') {
					rgMap[i][j] = 'R';
				}
			}
		} // 입력

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map[i][j], visited, map);
					count++;
				}
				if (!rgVisited[i][j]) {
					dfs(i, j, rgMap[i][j], rgVisited, rgMap);
					rgCount++;
				}
			}
		}

		System.out.println(count + " " + rgCount);

	}

	private static void dfs(int i, int j, char color, boolean[][] visited, char[][] map) {
		visited[i][j] = true;
		int nx = 0;
		int ny = 0;
		for (int k = 0; k < 4; k++) {
			nx = i + dx[k];
			ny = j + dy[k];
			// 범위 안에 있고
			// 같은 색이며
			// 아직 방문하지 않았으면
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == color && !visited[nx][ny]) {
				dfs(nx, ny, color, visited, map);
			}
		}

	}

}
