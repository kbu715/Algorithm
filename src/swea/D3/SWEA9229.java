package com.day6;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;
// 한빈이와 Spot Mart - D3

// 메모리 줄여보자

public class SWEA9229 {

	static int N;
	static int M;
	static int[] snacks;
	static int[] selected;
	static ArrayList<Integer> sumOfSelected;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/snack.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			N = sc.nextInt(); // 과자 봉지 개수
			M = sc.nextInt(); // 무게 합 제한

			snacks = new int[N];
			selected = new int[2]; // 정확히 두봉지여야 함

			sumOfSelected = new ArrayList<Integer>();

			for (int i = 0; i < N; i++) {
				snacks[i] = sc.nextInt();
			}

			comb(0, 0);
			int max = 0;
			if (sumOfSelected.size() == 0) {
				max = -1;
			} else {
				for (int i = 0; i < sumOfSelected.size(); i++) {
					if (max < sumOfSelected.get(i))
						max = sumOfSelected.get(i);
				}
			}

			// 출력
			System.out.println("#" + test_case + " " + max);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == 2) {
			int sum = getSum(selected);

			if (sum <= M) {
				sumOfSelected.add(sum);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			selected[cnt] = snacks[i];
			comb(cnt + 1, i + 1);
		}
	}

	private static int getSum(int[] arr) {
		int sum = 0;
		for (int i : arr) {
			sum += i;
		}
		return sum;
	}

}
