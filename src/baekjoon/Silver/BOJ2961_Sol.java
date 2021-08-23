package com.day9;

import java.util.Scanner;

// subset 부분집합 이용
public class BOJ2961_Sol {

	static int N; // 재료수
	static int[] sour; // 재료별 신맛 저장하는 배열
	static int[] bitter; // 재료별 쓴맛 저장하는 배열
	static boolean[] flag;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sour = new int[N];
		bitter = new int[N];

		flag = new boolean[N]; // t f f t t

		for (int i = 0; i < N; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		} // 입력 end

		subset(0);

		System.out.println(min);

	}

	private static void subset(int count) { // count: 현재까지 고려한 원소 수
		// base case
		if (count == N) {
			// 하나의 부분집합이 완성되면 할 일 -> 사용된 재료별 신맛, 쓴맛 계산후 그 차이 구하기
			int sum = 0; // 쓴맛
			int mul = 1; // 신맛

			for (int i = 0; i < N; ++i) {
				if (flag[i]) {
					mul = mul * sour[i];
					sum = sum + bitter[i];
				}
			}
			// 공집합인 경우 빼주자
			if (sum != 0) {
				min = Math.min(min, Math.abs(mul - sum)); // 기존 min과 방금 계산한 min중 더 작은 값
			}

			return;
		}

		// count번째 재료를 사용 하는 경우
		flag[count] = true;
		subset(count + 1);

		// count번째 재료를 사용 안하는 경우
		flag[count] = false;
		subset(count + 1);
	}

}
