package com.day7;

import java.util.Scanner;

public class SWEA1933 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 1;
		while (cnt <= N) {
			if (N % cnt == 0)
				System.out.print(cnt + " ");
			cnt++;
		}
	}

}
