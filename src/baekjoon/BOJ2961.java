package com.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
public class BOJ2961 {

	static int N;
	static boolean flagS[];
	static boolean flagB[];
	static int[] sArray;
	static int[] bArray;
	static int totalS = 1;
	static int totalB = 0;
	static LinkedList<Integer> totalSArray;
	static LinkedList<Integer> totalBArray;

	public static void main(String[] args) throws Exception {
		// 신맛 S와 쓴맛 B // 신맛은 사용한 재료의 신맛의 곱, 쓴맛은 합

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int S = 1;
		int B = 0;
		sArray = new int[N];
		bArray = new int[N];

		flagS = new boolean[N];
		flagB = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			sArray[i] = S;
			bArray[i] = B;
		}

		totalSArray = new LinkedList<>();
		totalBArray = new LinkedList<>();

		subsetS(0);
		subsetB(0);

		int min = Integer.MAX_VALUE;

		// 최소값 구하기
		for (int i = 0; i < totalSArray.size(); i++) {
			for (int j = 0; j < totalBArray.size(); j++) {
				if (totalSArray.get(i) == 0 || totalBArray.get(j) == 0) {
					continue;
				}
				int diff = Math.abs(totalSArray.get(i) - totalBArray.get(j)); // 차이값

				if (diff != 0 && min > diff) {
					min = diff;
				}
			}
		}
		System.out.println(min);

	}

	// 부분집합을 이용해서 신맛의 합을 리스트에 저장
	private static void subsetS(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (flagS[i]) {
					totalS *= sArray[i]; // 신맛은 곱
				}
			}
			totalSArray.add(totalS);
			totalS = 1; // 초기화
			return;
		}

		flagS[cnt] = true;
		subsetS(cnt + 1);
		flagS[cnt] = false;
		subsetS(cnt + 1);

	}

	// 쓴맛
	private static void subsetB(int cnt) {
		if (cnt == N) {
			for (int i = 0; i < N; i++) {
				if (flagB[i]) {
					totalB += bArray[i]; // 쓴맛은 합
				}
			}
			totalBArray.add(totalB);
			totalB = 0; // 초기화
			return;
		}

		flagB[cnt] = true;
		subsetB(cnt + 1);
		flagB[cnt] = false;
		subsetB(cnt + 1);

	}
}
