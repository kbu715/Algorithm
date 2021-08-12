package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//최대수 구하기 D1
public class SWEA2068 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		Queue<StringBuffer> sq = new LinkedList<>();
		for (int i = 0; i < T; i++) {
			StringBuffer sb = new StringBuffer();
			sb.append("#" + (i + 1) + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (max < num)
					max = num;
			}

			sb.append(max + "\n");
			sq.offer(sb);
		}

		while (!sq.isEmpty()) {
			System.out.print(sq.poll());
		}
	}

}
