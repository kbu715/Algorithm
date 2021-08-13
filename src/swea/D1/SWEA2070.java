package com.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2070 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			char result = '0';
			if (A - B > 0)
				result = '>';
			else if (A - B < 0)
				result = '<';
			else
				result = '=';
			sb.append("#" + tc).append(" " + result).append("\n");
		}
		System.out.println(sb);
	}

}
