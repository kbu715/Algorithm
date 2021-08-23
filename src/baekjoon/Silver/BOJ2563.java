package com.day7;

import java.util.Scanner;
// 색종이
public class BOJ2563 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] paper = new int[100][100];

		int T = sc.nextInt();

		int sum = 0;

		for (int i = 0; i < T; i++) {

			int length = 10; // 색종이 한변의 길이
			int x = sc.nextInt();
			int y = sc.nextInt();

			for (int j = x; j < x + length; j++) {
				for (int j2 = y; j2 < y + length; j2++) {
					paper[j][j2] = 1;
				}
			}

		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (paper[i][j] == 1) {
					sum++;
				}
			}
		}

		System.out.println(sum);
	}

}
