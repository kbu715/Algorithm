package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 신문 헤드라인
public class SWEA2047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		String[] temp = br.readLine().split("");
		for (int i = 0; i < temp.length; i++) {
			temp[i] = temp[i].toUpperCase();
			sb.append(temp[i]);
		}
		System.out.println(sb);
	}

}
