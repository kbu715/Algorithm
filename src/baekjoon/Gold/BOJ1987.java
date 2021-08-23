package com.day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//알파벳 골드4
public class BOJ1987 {

	static int R;
	static int C;
	static String[][] map;
	static int max;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new String[R][C];
		for (int i = 0; i < R; i++)
			map[i] = br.readLine().split("");

		String start = map[0][0];
		move(0, 0, 1, start);
		System.out.println(max);
	}

	private static void move(int r, int c, int cnt, String str) {
		if (r > 0 && !str.contains(map[r - 1][c])) { // 상
			move(r - 1, c, cnt + 1, str + map[r - 1][c]);
		}
		if (r < R - 1 && !str.contains(map[r + 1][c])) { // 하
			move(r + 1, c, cnt + 1, str + map[r + 1][c]);
		}
		if (c > 0 && !str.contains(map[r][c - 1])) { // 좌
			move(r, c - 1, cnt + 1, str + map[r][c - 1]);
		}
		if (c < C - 1 && !str.contains(map[r][c + 1])) { // 우
			move(r, c + 1, cnt + 1, str + map[r][c + 1]);
		} else {
			max = Math.max(max, cnt);
		}
	}
}