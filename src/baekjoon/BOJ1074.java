package com.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과 

public class BOJ1074 {

	static int N;
	static int cnt;
	static int r;
	static int c;
	static int[] dx = { 0, 0, 1, 1 }; // row 변화값 배열
	static int[] dy = { 0, 1, 0, 1 }; // col 변화값 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		search((int) Math.pow(2, N), 0, 0);

	}

	private static void search(int N, int row, int col) {
		if (N == 2) { // 최소 2x2 기저조건
			for (int i = 0; i < 4; i++) {
				int nr = row + dx[i];
				int nc = col + dy[i];
				if (nr == r && nc == c) {
					System.out.println(cnt);
					break;
				}
				cnt++;
			}
			return;
		}
		search(N / 2, row, col); // 왼쪽 상단
		search(N / 2, row, col + N / 2); // 오른쪽 상단
		search(N / 2, row + N / 2, col); // 왼쪽 하단
		search(N / 2, row + N / 2, col + N / 2); // 오른쪽 하단
	}

}
