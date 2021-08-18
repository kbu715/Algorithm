package com.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1285 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int result = 0;

			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int min = Integer.MAX_VALUE;
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {
				if (min > Math.abs(arr[i])) {
					min = Math.abs(arr[i]);
				}
			}
			result = min;
			for (int i = 0; i < arr.length; i++) {
				if (min == Math.abs(arr[i])) {
					cnt++;
				}
			}

			sb.append("#" + tc + " " + result + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

}
