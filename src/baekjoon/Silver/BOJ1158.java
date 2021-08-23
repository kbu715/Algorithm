package com.day7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 요세푸스 문제 - 실버 5
public class BOJ1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> list = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			list.add(i + 1); // 1 2 3 4 5 6 7
		}

		System.out.print("<");
		int idx = 0;
		while (true) {
			if (list.size() <= 1)
				break;
			idx += (K - 1); // 2 4 1 3 2 0 2 // +K 가 아니라 +(K-1) 인 이유 : 하나씩 삭제가 되기 때문에
			idx %= list.size();
			System.out.print(list.remove(idx) + ", ");
		}
		System.out.print(list.get(0));
		System.out.println(">");
	}

}
