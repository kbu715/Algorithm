package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1987_Sol {

	static int R, C;
	static char[][] map;
	static HashSet<Character> trace = new HashSet<>();
	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };
	static int max;
	static boolean flag = false;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

//		print();
		trace.add(map[0][0]);
		search(0, 0, trace);
		System.out.println(max);
	}

	static void print() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	// x,y는 현재 위치 좌표, trace는 지금까지 걸으면서 만났던 알파벳들 담아놓은 셋
	static void search(int x, int y, HashSet<Character> trace) {
		// 사방탐색
		flag = false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && ny >= 0 && nx < R && ny < C && !trace.contains(map[nx][ny])) {// 아직 안가본 알파벳이면

				trace.add(map[nx][ny]);// 나 담고
				search(nx, ny, trace);
				trace.remove(map[nx][ny]);// 나 빼고
				flag = true;// 사방탐색 최소 한군데는 하고옴
			}
		}

		if (!flag) {// 사방탐색 한군데도 못했으면
			max = Math.max(max, trace.size());
			return;
		}
	}

}
