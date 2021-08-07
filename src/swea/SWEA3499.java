package com.day5;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 퍼펙트 셔플
class SWEA3499 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		Queue<String> q1 = new LinkedList<>();
		Queue<String> q2 = new LinkedList<>();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 갯수

			String[] array = new String[N];

			int C = (int) Math.ceil(N / 2);

			for (int i = 0; i < N; i++) {
				array[i] = sc.next();
				if (i < C) {
					q1.offer(array[i]);
				} else
					q2.offer(array[i]);
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < C; i++) {
				if (!q1.isEmpty()) {
					System.out.print(q1.poll() + " ");
				}
				if (!q2.isEmpty()) {
					System.out.print(q2.poll() + " ");
				}
			}
			System.out.println();
		}
	}
}