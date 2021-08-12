package com.day7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158_Sol {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // 7 3

		int N = Integer.parseInt(st.nextToken()); // 7 전체 인원수
		int K = Integer.parseInt(st.nextToken()); // 3 제거될 사람의 순서

		StringBuilder sb = new StringBuilder();
		sb.append("<");

		// 전체 인원 Queue에 저장
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i); // q.add(new Integer(i)); // 이렇게 자동 박싱이 된다. // 포장된다
		}

		// K번째 사람 삭제. Queue 사이즈가 1이 될때까지.
		while (q.size() != 1) {
			for (int i = 0; i < K - 1; i++) {
				q.offer(q.poll()); // 앞에서 꺼낸거 맨뒤로 보냄
			}

			// K번째 사람은 제거
			sb.append(q.poll() + " ");
		}

		// Queue에 한사람만 남은 경우
		sb.append(q.poll() + ">");

		System.out.println(sb);
	}

}
