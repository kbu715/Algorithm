package com.day1;

import java.util.Scanner;

public class BOJ1149 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] costs = new int[N+1][4]; // 1~N번까지 각 집마다 R - G - B 순으로 칠하는 비용 (1~3)
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= 3; j++) {
				costs[i][j] = sc.nextInt();
			}
		}
		
		int[][] D = new int[N+1][4]; // 현재까지의 최소의 비용을 담을 동적테이블
		
		for (int d = 1; d <= N; d++) {
			D[d][1] = Math.min(D[d-1][2], D[d-1][3]) + costs[d][1]; // N번째 집 색이 빨강일때, (N-1번째 집 색이 초록, 파랑 중 작은 비용 중 작은 비용 + N번째 집 빨강 비용) 
			D[d][2] = Math.min(D[d-1][1], D[d-1][3]) + costs[d][2]; // N번째 집 색이 초록일때, (N-1번째 집 색이 빨강, 파랑 중 작은 비용 중 작은 비용  + N번째 집 초록 비용)
			D[d][3] = Math.min(D[d-1][1], D[d-1][2]) + costs[d][3]; // N번째 집 색이 파랑일때, (N-1번째 집 색이 빨강, 초록 중 작은 비용 중 작은 비용  + N번째 집 파랑 비용)
		}
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 1; i <= 3; i++) {
			answer = Math.min(answer, D[N][i]);
		}

		System.out.println(answer);
		sc.close();
	}

}
