package com.ssafy.algoclass.day5;

import java.util.Arrays;

// 순열

// N개의 서로 다른 수에서 뽑는 순열

// 비트마스킹을 통한 순열 생성 - 비트연산자를 이용
public class PermutationTest2 {

	static int N = 5, R = 3; // n P r !!! // R은 빅픽처였다
	static int[] input; // 숫자 배열
	static int[] numbers; // 순열 저장 배열

	public static void main(String[] args) {

		input = new int[] { 1, 4, 7, 11, 20 }; // Todo: 나중에 입력으로 바꾸기
		numbers = new int[R];

		permutation(0, 0);

	}

	private static void permutation(int cnt, int flag) {

		if (cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}

		// 가능한 모든 수들이 들어있는 배열 모든 원소에 대해 시도
		for (int i = 0; i < N; i++) { // i: index
			if ((flag & 1 << i) != 0) { // 사용중인 수면 다음 수로 // mask off
				continue;
			}

			numbers[cnt] = input[i];

			// 다음 자리순열 뽑으러 gogo
			// mask on
			permutation(cnt + 1, (flag | 1 << i)); // flag의 값을 직접 건들지 않기 때문에 사용중이지 않음으로 되돌릴 필요가 없다.
		}
	}

}
