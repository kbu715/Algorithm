package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987_Sol2 {

	static int R, C;
	static int[][] map;
	static boolean[] visit = new boolean[26]; // 알파벳 26글자의 사용여부 체크하는 배열
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer; // 답

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j) - 'A'; // 'A' - 'A' = 0 // 'B' - 'A' = 1 // 'C' - 'A' = 2 // ...
			}
		} // 입력완료

		// 글자길이 세러감
		find(0, 0, 0); // (x, y, cnt) x,y는 시작점. cnt는 이제껏 방문한 글자수
		System.out.println(answer);
	}

	// x, y 위치에서 시작해서 가능한 곳까지 진행한 후 지금껏 방문했던 알파벳 길이를 계산하는 메소드
	private static void find(int x, int y, int cnt) {
		// 1.종료조건
		// ex) CAAB: C 방문한 경우
		// visit[map[x][y]] -> visit[2]: C의 사용여부가 저장되어 있는 칸
		if (visit[map[x][y]]) { // 해당 글자 이미 방문했었음
			answer = Math.max(answer, cnt);
			return;
		}

		// 2.반복조건 - 4방탐색
		else { // 해당글자 첫방문
			visit[map[x][y]] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) { // 배열 안이라면 탐색 가능
					find(nx, ny, cnt + 1);
				}
			}
			// x, y 위치에서 4방 탐색을 다 마침.
			// 이전 자기를 호출했던 곳으로 돌아가면서 다른 경로로도 이 x, y위치에 접근이 가능하도록
			// 미방문 처리를 해줘야된다.
			visit[map[x][y]] = false;
		}
	}

}
