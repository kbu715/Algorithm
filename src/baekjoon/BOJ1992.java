package com.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 쿼드트리 - 실버1
public class BOJ1992 {

	static int N;
	static ArrayList<String> result;
	static ArrayList<String> temp;
	static String[][] map;
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());

		map = new String[N][N];
		result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		search(N, 0, 0);

		compress(result, N);
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i));
		}

		System.out.println(sb);

	}

	private static void compress(ArrayList<String> list, int n) {
		if (n <= 1) {
			result = list;
			return;
		}

		String s = "";
		temp = new ArrayList<>();

		for (int i = 0; i < list.size(); i += 4) {
			for (int j = i; j < i + 4; j++) {
				s += list.get(j);
			}
			if (s.equals("0000")) {
				temp.add("0");
			} else if (s.equals("1111")) {
				temp.add("1");
			} else {
				temp.add("(" + s + ")");
			}
			s = "";
		}
		compress(temp, n / 2);

	}

	private static void search(int n, int row, int col) {
		if (n == 2) {
			for (int i = 0; i < 4; i++) {
				int nr = row + dx[i];
				int nc = col + dy[i];
				result.add(map[nr][nc]);
			}
			return;
		}

		int mid = n / 2;

		search(mid, row, col); // 왼쪽 상단
		search(mid, row, col + mid); // 오른쪽 상단
		search(mid, row + mid, col); // 왼쪽 하단
		search(mid, row + mid, col + mid); // 오른쪽 하단

	}

}
