package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 날짜 계산기 D2
public class SWEA1948 {

	static HashMap<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		map = new HashMap<>();

		map.put(1, 31); map.put(2, 28);
		map.put(3, 31); map.put(4, 30);
		map.put(5, 31); map.put(6, 30);
		map.put(7, 31); map.put(8, 31);
		map.put(9, 30); map.put(10, 31);
		map.put(11, 30);map.put(12, 31);

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int answer = 0;
			int M1 = Integer.parseInt(st.nextToken());
			int D1 = Integer.parseInt(st.nextToken());
			int M2 = Integer.parseInt(st.nextToken());
			int D2 = Integer.parseInt(st.nextToken());

			answer = calc(M1, M2, D1, D2);

			sb.append("#" + tc + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	private static int calc(int m1, int m2, int d1, int d2) {
		if (m1 == m2) {
			return d2 - d1 + 1;
		} else {
			int total2 = 0, total1 = 0;
			for (int i = 1; i < m2; i++) {
				total2 += map.get(i);
			}
			for (int j = 1; j < m1; j++) {
				total1 += map.get(j);
			}
			total2 += d2;
			total1 += d1;

			return total2 - total1 + 1;
		}
	}

}
