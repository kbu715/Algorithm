package com.day11;

import java.util.Scanner;

public class SWEA1204 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		int[] array;
		int cnt = 0;
		int max;
		while (cnt < T) {
			int tc = sc.nextInt();
			array = new int[101];
			max = 0;
			for (int i = 0; i < 1000; i++) {
				int num = sc.nextInt();
				array[num]++;
				if (array[num] > max)
					max = array[num];
			}
			int maxIndex = -1;
			for (int i = 0; i < 101; i++) {
				if (array[i] != max)
					continue;
				maxIndex = i;
			}
			System.out.printf("#%d %d\n", tc, maxIndex);
			cnt++;
		}
		sc.close();
	}
}