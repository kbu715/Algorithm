package com.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가위 1 바위 2 보 3
public class SWEA1936 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		if ((A == 1 && B == 3) | (A == 2 && B == 1) | (A == 3 && B == 2)) {
			System.out.println("A");
		} else {
			System.out.println("B");
		}
	}

}
