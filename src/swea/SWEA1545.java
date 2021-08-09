package com.day6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA1545 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		while (N >= 0) {
			System.out.print(N + " ");
			N--;
		}

	}

}
