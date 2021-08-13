package com.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2046 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			sb.append('#');
		}

		System.out.println(sb);
	}

}
