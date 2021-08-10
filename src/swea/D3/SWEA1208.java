package com.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	private static int[] dump(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		int maxIdx = 0;
		int minIdx = 0;

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				maxIdx = i;
			}
			if (min > arr[i]) {
				min = arr[i];
				minIdx = i;
			}
		}
		arr[maxIdx] -= 1;
		arr[minIdx] += 1;

		return arr;
	}

	private static int checkGap(int[] arr) {
		int max = arr[0];
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
		}

		return max - min;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int i = 0; i < T; i++) {
			int nDump = sc.nextInt();
			int[] arr = new int[100];

			for (int j = 0; j < 100; j++) {
				arr[j] = sc.nextInt();
			}

			for (int k = 0; k < nDump; k++) {
				arr = dump(arr);
			}

			System.out.println("#" + (i + 1) + " " + checkGap(arr));
		}
	}
}