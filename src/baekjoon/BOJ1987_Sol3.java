package com.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1987_Sol3 {

	static int R, C;
	static int[][] map;
	static boolean[] visit = new boolean[26];// 알파벳 26개 들어갈 배열 만들어서 사용여부 체크
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cc;

	static int ans = 0;
	static String src = "2 4\r\n" + "CAAB\r\n" + "ADCB";
	static String msg = "";

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A';// A:0, B:1 ...
			}
		} // 입력
			// System.out.println(Arrays.deepToString(map));
		dfs(0, 0, 0);
		// (0,0)부터 시작하며, 현재 이동한 위치는 0회
		System.out.println(ans);
	}

	// X,Y에서 시작해서 가능한 곳까지 진행해서 횟수 계산하는 메소드
	public static void dfs(int x, int y, int count) {
		System.out.print("(" + x + ":" + y + ":" + count + ")=> ");
		String tab = "\t";
		for (int i = 0; i < count; i++) {
			tab += "\t";
		}

		if (visit[map[x][y]]) { // 저장된 알파벳이 이미 한번 방문한 알파벳이라면,더이상 못가니까
			System.out
					.println((char) (65 + map[x][y]) + ". 이미 방문한 곳." + " 지금까지 방문글자: [" + msg + "] " + "count:" + count);

			ans = Math.max(ans, count); // 정답을 갱신해준다.
			return; // 조건에 만족하므로 리턴.

		} else {

			visit[map[x][y]] = true;// yet visit.현재위치 방문 표시 갱신
			msg += (char) (65 + map[x][y]) + "";
			System.out.println((char) (65 + map[x][y]) + ". 처음방문. 지금까지 방문글자: [" + msg + "]");
			for (int i = 0; i < 4; i++) {// 4방 방문

				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < R && ny < C) {// 갈 곳이 있으면 거기서부터 다시 4방 탐색하라
					System.out.print(tab + (char) (65 + map[x][y]) + "에서  ");
					switch (i) {
					case 0:
						System.out.print(" 상 ");
						break;
					case 1:
						System.out.print(" 하 ");
						break;
					case 2:
						System.out.print(" 좌 ");
						break;
					case 3:
						System.out.print(" 우 ");
						break;
					}

					dfs(nx, ny, count + 1);
				}
			}
			// x,y위치에서 4방 탐색이 다 끝났다면 이전 호출로 돌아가면서 다른 경로로도 이곳에 접근 가능하도록 미방문 처리해놓음
			visit[map[x][y]] = false;
			msg = msg.substring(0, msg.length() - 1);

		}
	}
}