package com.day13;

import java.util.Scanner;
// 부분집합의 합 구하기 - 가지치기 이용
public class S1_SubsetSumTest {

	static int N, totalCnt2, totalCnt3, S;
	static int[] input;
	static boolean[] isSelected;
	static int callCnt2, callCnt3;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 몇개 원소
		S = sc.nextInt(); // 목표합
		input = new int[N];
		isSelected = new boolean[N];
		callCnt3 = callCnt2 = totalCnt2 = totalCnt3 = 0;

		for (int i = 0; i < N; i++) {

			input[i] = sc.nextInt();

		}

		generateSubset2(0, 0); // 부분집합에 고려된 원소수 일단 0으로 시작
		System.out.println("경우의 수: " + totalCnt2 + ", 호출 횟수: " + callCnt2);

		generateSubset3(0, 0); // 부분집합에 고려된 원소수 일단 0으로 시작
		System.out.println("가지치기의 경우의 수: " + totalCnt3 + ", 호출 횟수: " + callCnt3);

		// Note: 가지치기의 효과가 큰 경우가 존재한다. 아닌경우도 있고... 하지만 절대적이진 않다
	}

	// 가지치기 추가된 메소드
	private static void generateSubset3(int cnt, int sum) { // cnt: 부분집합을 처리하기 위해 고려된 원소수
		callCnt3++;
		// sum : 기존까지 부분집합 구성원소들의 합
		// 부분집합의 합 == 목표합 체크
		if (sum == S) {

			totalCnt3++;
			for (int i = 0; i < N; i++) {
				if (isSelected[i])
					System.out.print(input[i] + " ");
			}
			System.out.println();
			return;
		}

		if (sum > S || cnt == N)
			return; // 이전으로 돌아가자

		isSelected[cnt] = true;
		generateSubset3(cnt + 1, sum + input[cnt]);
		isSelected[cnt] = false;
		generateSubset3(cnt + 1, sum);
	}

	private static void generateSubset2(int cnt, int sum) { // cnt: 부분집합을 처리하기 위해 고려된 원소수
		callCnt2++; // sum : 기존까지 부분집합 구성원소들의 합
		if (cnt == N) {
			// 부분집합 완성

			// 부분집합의 합 == 목표합 체크
			if (sum == S) {

				totalCnt2++;
				for (int i = 0; i < N; i++) {
					if (isSelected[i])
						System.out.print(input[i] + " ");
				}
				System.out.println();
			}
			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true;
		generateSubset2(cnt + 1, sum + input[cnt]);
		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false;
		generateSubset2(cnt + 1, sum);
	}

//	private static void generateSubset(int cnt) { // cnt: 부분집합을 처리하기 위해 고려된 원소수
//
//		if (cnt == N) {
//			// 부분집합 완성
//
//			// 부분집합의 합을 계산
//			int sum = 0;
//			for (int i = 0; i < N; i++) {
//				if (isSelected[i])
//					sum += input[i];
//			}
//
//			// 부분집합의 합 == 목표합 체크
//			if (sum == S) {
//
//				totalCnt++;
//				for (int i = 0; i < N; i++) {
//					if (isSelected[i])
//						System.out.print(input[i] + " ");
//				}
//				System.out.println();
//			}
//			return;
//		}
//
//		// 현재 원소를 부분집합에 넣기
//		isSelected[cnt] = true;
//		generateSubset(cnt + 1);
//		// 현재 원소를 부분집합에 넣지 않기
//		isSelected[cnt] = false;
//		generateSubset(cnt + 1);
//	}

}
