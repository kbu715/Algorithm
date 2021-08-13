package com.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 평균값 구하기
public class SWEA2071 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] temp = br.readLine().split(" ");
			double total = 0.0;
			int result = 0;
			for (String s : temp) {
				total += Integer.parseInt(s);
			}

			result = (int) (Math.round(total / temp.length));

			System.out.println("#" + tc + " " + result);
		}
	}

}
