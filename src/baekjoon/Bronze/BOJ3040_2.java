package com.day9;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ3040_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			int n = sc.nextInt();

			list.add(n);
			sum += n;
		}

		for (int j = 0; j < list.size() - 1; j++) {
			for (int k = j + 1; k < list.size(); k++) {
				if ((sum - (list.get(j) + list.get(k))) == 100) {
					list.remove(k);
					list.remove(j);
				}
			}
		}

		for (int n : list) {
			System.out.println(n);
		}

		sc.close();
	}
}