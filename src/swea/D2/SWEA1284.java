package com.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1284 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int result = 0;

			int P = Integer.parseInt(st.nextToken()); // 1L당 요금 (A)
			int Q = Integer.parseInt(st.nextToken()); // R리터 이하 요금 (B)
			int R = Integer.parseInt(st.nextToken()); // 제한 (B)
			int S = Integer.parseInt(st.nextToken()); // 1L당 요금 (B)
			int W = Integer.parseInt(st.nextToken()); // 한달간 사용하는 수도의 양 W리터

			int A = W * P;
			int B = R - W >= 0 ? Q : (W - R) * S + Q;

			int min = Math.min(A, B);

			result = min;

			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}

}
