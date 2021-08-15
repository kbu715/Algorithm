package com.day9;

import java.util.Scanner;

public class BOJ3040 {

	static int[] nums;
	static int[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		nums = new int[9];
		selected = new int[7];

		for (int i = 0; i < 9; i++) {
			nums[i] = sc.nextInt();
		}

		combination(0, 0);
	}

	private static void combination(int cnt, int start) {
		// 하나의 조합이 완성되면 100인지 확인
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
			}
			return;
		}
		for (int i = start; i < 9; ++i) {
			selected[cnt] = nums[i];
			combination(cnt + 1, i + 1);
		}
	}

}
