package com.day7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// N줄 덧셈 - D1
public class SWEA2025 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int cnt = 1;
		int sum = 0;
		while (cnt <= N) {
			sum += cnt;
			cnt++;
		}
		System.out.println(sum);
	}

}
