package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서랍의 비밀번호
public class SWEA2043 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int P = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(P - K + 1);
	}

}
