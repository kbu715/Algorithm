package com.day2;

import java.util.Scanner;

public class BOJ1149_Sol {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		// 각 집을 칠할 비용
		int[][] cost = new int[N+1][3];
		
		// 1번집부터 n번 집까지 칠하는 데 필요한 최소비용
		int[][] d = new int[N+1][3];
		
		
		// 입력
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		
		// 초기값
		int red = 0, green = 1, blue = 2;
		
		// 첫번째 집 칠하는데 들어가는 최소 비용 : 첫번째 집~첫번째집 까지 칠하는데 들어가는 최소비용
		d[1][red] = cost[1][red];
		d[1][green] = cost[1][green];
		d[1][blue] = cost[1][blue];
		
		// i번째 집까지 칠하는데 드는 최소비용 = (i)자기집 칠하는 비용 + (i-1)번째 집까지 칠하는 비용 중 최소값
		
		for (int i = 2; i <= N; i++) {
			d[i][red] = cost[i][red] + Math.min(d[i-1][blue], d[i-1][green]);
			d[i][green] = cost[i][green] + Math.min(d[i-1][red], d[i-1][blue]);
			d[i][blue] = cost[i][blue] + Math.min(d[i-1][red], d[i-1][green]);
		}
		
		int answer = Math.min(Math.min(d[N][red], d[N][green]), d[N][blue]);
		System.out.println(answer);
		sc.close();
	}

}
