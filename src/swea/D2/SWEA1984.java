package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

// 중간 평균값 구하기 D2
public class SWEA1984 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			LinkedList<Integer> list = new LinkedList<>();
			String[] temp = br.readLine().split(" ");

			for (String s : temp) {
				list.add(Integer.parseInt(s));
			} // 입력끝

			// 정렬
			Collections.sort(list);

			list.remove(0);
			list.remove(list.size() - 1);

			double total = 0.0;
			for (int i = 0; i < list.size(); i++) {
				total += list.get(i);
			}

			answer = (int) Math.round(total / list.size());

			sb.append("#" + tc + " " + answer + "\n");
		}

		System.out.println(sb);
	}

}
