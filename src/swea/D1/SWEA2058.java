package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 자릿수 더하기 D1
public class SWEA2058 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] temp = br.readLine().toCharArray();
		int sum = 0;
		for (char c : temp) {
			sum += c - '0';
		}
		System.out.println(sum);
	}

}
