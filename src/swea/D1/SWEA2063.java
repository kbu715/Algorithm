package com.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA2063 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] arr = new int[T];
		int cnt = 0;
		for (String s : temp) {
			arr[cnt++] = Integer.parseInt(s);
		}
		Arrays.sort(arr);
		int center = T / 2;
		System.out.println(arr[center]);
	}

}
