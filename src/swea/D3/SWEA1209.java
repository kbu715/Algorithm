package com.day17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA 1209 SUM D3
public class SWEA1209 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			int[][] map = new int[100][100];
			int tc = Integer.parseInt(br.readLine());
			int answer = 0;
			for (int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < 100; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 열의 합 중 최대값
			int colSum = 0;
			int maxColSum = 0;
			for (int c = 0; c < 100; c++) {
				for (int r = 0; r < 100; r++) {
					colSum += map[r][c];
				}
				maxColSum = Math.max(maxColSum, colSum);
				colSum = 0;
			}

			// 행의 합 중 최대값
			int rowSum = 0;
			int maxRowSum = 0;
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					rowSum += map[r][c];
				}
				maxRowSum = Math.max(maxRowSum, rowSum);
				rowSum = 0;
			}

			// 대각선
			int dLineSum = 0;
			int dLineSum2 = 0;
			int maxDLineSum;

			for (int r = 0; r < 100; r++) {
				dLineSum += map[r][r];
				dLineSum2 += map[r][99 - r];
			}

			maxDLineSum = Math.max(dLineSum, dLineSum2);

			answer = Math.max(Math.max(maxRowSum, maxColSum), maxDLineSum);

			System.out.println("#" + tc + " " + answer);
		}

	}

}
