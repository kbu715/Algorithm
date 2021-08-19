package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 간단한 소인수 분해  D2
public class SWEA1945 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());
			int a = 0, b = 0, c = 0, d = 0, e = 0;
			while (N % 2 == 0) {
				N /= 2;
				a++;
			}
			while (N % 3 == 0) {
				N /= 3;
				b++;
			}
			while (N % 5 == 0) {
				N /= 5;
				c++;
			}
			while (N % 7 == 0) {
				N /= 7;
				d++;
			}
			while (N % 11 == 0) {
				N /= 11;
				e++;
			}

			sb.append("#" + tc + " " + a + " " + b + " " + c + " " + d + " " + e + "\n");
		}

		System.out.println(sb);
	}

}
