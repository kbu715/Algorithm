package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 지그재그 숫자 D2
public class SWEA1986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int total = 0;
			for (int i = 1; i <= N; i++) {
				if (i % 2 == 0)
					total -= i;
				else
					total += i;
			}

			sb.append("#" + tc + " " + total + "\n");

		}
		System.out.println(sb);

	}

}
