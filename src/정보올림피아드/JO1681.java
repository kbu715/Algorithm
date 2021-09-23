package com.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 해밀턴 순환 회로
public class JO1681 {

	static int N;
	static int[][] cost;
	static int[] selected;
	static boolean[] flag;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		cost = new int[N + 1][N + 1];
		selected = new int[N - 1];
		flag = new boolean[N + 1];
		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		perm(0, 1, 0);
		System.out.println(min);

	}

	private static void perm(int cnt, int prev, int sum) {
		if (cnt == N - 1) {
			// 순열 완성
			sum += cost[prev][1];

			min = Math.min(min, sum);
			return;
		}
		for (int i = 2; i <= N; i++) {
			if (flag[i])
				continue;

			flag[i] = true;
			selected[cnt] = i;

			if (sum + cost[prev][i] > min) {
				flag[i] = false;
				return;
			}

			if (cost[prev][i] != 0) {
				perm(cnt + 1, i, sum + cost[prev][i]);
				flag[i] = false;
			} else {
				flag[i] = false;
				return;
			}

		}
	}

}
