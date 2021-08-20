package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 초심자의 회문 검사 D2
public class SWEA1989 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			int answer = 1;

			char[] temp = br.readLine().toCharArray();
			int half = temp.length / 2;
			for (int j = 0; j < half; j++) {
				if (temp[j] != temp[temp.length - 1 - j]) {
					answer = 0;
					break;
				}
			}

			sb.append("#" + i + " " + answer + "\n");
		}
		System.out.println(sb);
	}

}
