package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3109_Sol {

	static int R, C;
	static char[][] map;
	static int[] dir = { -1, 0, 1 }; // 우상, 우, 우하 // y값은 기존값에 +1만 해주면 됨.
	static int answer; // 답. 완성된 파이프라인 수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		} // 입력

		// 맨윗줄 첫번째 열에서부터 검사(0,0 -> 1,0 -> 2,0)
		// 중요: 맨 윗 행부터 돌아야 최대값을 구할 수 있음
		for (int i = 0; i < R; i++) {
			connect(i, 0); // 행값, 열값
		}

		System.out.println(answer);
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}

	// (x,y) 위치에서부터 출발해서 3방향을 탐색후 끝열에 도착 가능한지 여부를 알려주는 메소드
	private static boolean connect(int x, int y) {

		// 1. 종료조건: 끝열에 도착한 경우. 파이프라인 한개 완성
		if (y == C - 1) {
			answer++;
			return true;
		}

		// 2. 반복조건: 끝에 아직 도달을 안해서 3방향을 체크 하면서 나가는 작업
		// 3방향 중에서 한방향이라도 성공을 하면 다른 방향은 시도하면 안됨
		for (int d = 0; d < 3; d++) { // 우상 --> 우 --> 우하
			int nx = x + dir[d];
			int ny = y + 1;

			if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != 'x' && map[nx][ny] != '@') {
				map[nx][ny] = '@'; // 여기 지나갔습니다. 마킹! // 영역표시
				boolean result = connect(nx, ny);
				if (result) {
					return true;
				}
			}
		} // for문 끝
			// 3방향 모두 끝까지 도달못하면
		return false;

	}

}
