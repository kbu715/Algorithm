package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 홀수만 더하기 - D1
public class SWEA2072 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		Queue<StringBuffer> sq = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("#" + (i + 1) + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sum = 0;
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (num % 2 == 1)
					sum += num;
			}

			sb.append(sum + "\n");
			sq.offer(sb);
		}

		while (!sq.isEmpty()) {
			System.out.print(sq.poll());
		}
	}

}
