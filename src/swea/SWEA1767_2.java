package com.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA1767_2 {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, map[][], max, min, totalCnt; // max : 연결한 최대 코어수, min : 최소전선길이의합
	static ArrayList<int[]> list; // 가장자리가 아닌 코어들의 위치를 저장한 리스트

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0; //////////////////////// 추가
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					// 가장자리 코어는 저장하지 않는다.
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++; // 가장자리가 아닌 코어개수
					}
				}
			}
			go(0, 0);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void go(int index, int cCnt) {
		if (index == totalCnt) {
			int res = getLength();
			// 선택된 코어 개수로 max 갱신
			if (max < cCnt) {
				max = cCnt;
				min = res;
			} else if (max == cCnt) { // 코어개수가 같아면 최소전선길이의 합
				if (min > res)
					min = res;
			}
			return;
		}

		int[] cur = list.get(index);
		int r = cur[0];
		int c = cur[1];
		// index 코어 선택 : 4방향 시도
		for (int d = 0; d < 4; d++) {
			if (isAvailable(r, c, d)) {
				// 전선 놓기
				setStatus(r, c, d, 2);
				// 다음 코어로
				go(index + 1, cCnt + 1);
				// 놓았던 전선 지우기
				setStatus(r, c, d, 0);
			}
		}
		// index 코어 미선택
		go(index + 1, cCnt);
	}

	private static void setStatus(int r, int c, int d, int s) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;
			map[nr][nc] = s;
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nr >= N || nc < 0 || nc >= N)
				break;
			if (map[nr][nc] >= 1)
				return false; // 코어나 전선이 있는 경우
		}
		return true;
	}

	private static int getLength() {
		int res = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 2)
					res++;
			}
		}
		return res;
	}

}
