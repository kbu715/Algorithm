package com.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 아주 간단한 계산기
public class SWEA1938 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		sb.append(A + B + "\n").append(A - B + "\n").append(A * B + "\n").append(A / B);
		System.out.println(sb);
	}

}
