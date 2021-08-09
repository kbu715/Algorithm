package com.ssafy.algoclass.day3;

import java.util.LinkedList;
import java.util.Queue;

public class MyChewTest {

	public static void main(String[] args) {
		int N = 20; // 지급할 마이쮸 개수
		Queue<int[]> queue = new LinkedList<>(); // 사람번호, 마이쮸 개수

		int person = 1; // 사람번호

		queue.offer(new int[] { person, 1 });

		while (N > 0) {
			if (!queue.isEmpty()) {
				int[] p = queue.poll(); // 꺼냈다
				int availableCnt = N >= p[1] ? p[1] : N;
				N -= availableCnt;

				if (N == 0) { // 이 순간 마지막으로 가져가는 사람이 정해진다.
					System.out.println("마지막 마이쮸를 가져간 사람: " + p[0] + "번, 가져간 개수: " + availableCnt);
				} else {
					System.out.println(p[0] + "번이" + availableCnt + "만큼 마이쮸를 가져갑니다. 남은개수: " + N);
					p[1]++; // 받고자 하는 마이쮸개수 증가
					queue.offer(p);
					queue.offer(new int[] { ++person, 1 });
				}
			}
		}
	}

}
