package com.ssafy.algoclass.day5;

import java.util.Arrays;

/* <Algorithm>
 * 배열을 오름차순으로 정렬한 후 시작한다.
 * 
 * 1. 뒤쪽부터 탐색하며 교환위치 (i-1)찾기 (i:꼭대기)
 * 2. 뒤쪽부터 탐색하며 교환위치 (i-1)와 교환할 큰 값(처음으로 자신보다 커지는 값) 위치 찾기(j)
 * 3. 두 위치 값 (i-1, j) swap!
 * 4. 꼭대기 위치부터(i) 맨 뒤까지 오름차순 정렬
 */

public class NextPermutationTest {

	public static void main(String[] args) {
		int[] input = { 7, 1, 4 };

		Arrays.sort(input); // 가장 작은 순열 만들기 -> 1, 4, 7

		do {
			// 순열 사용
			System.out.println(Arrays.toString(input));

		} while (np(input));

	}

	// 다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) { // next permutation

		int N = numbers.length;

		// step 1. 꼭대기(i)를 찾는다. 꼭대기를 통해 교환 위치(i-1) 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;

		if (i == 0)
			return false; // 다음 순열은 없다 -> 절벽이다

		// step 2. i-1 위치값과 교환할 큰 값 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) // 이미 꼭대기를 찾고 내려왔으므로 i-1 위치 값보다 큰 값은 반드시 존재한다.
			--j;

		// step3. i-1위치값과 j위치값 교환
		swap(numbers, i - 1, j);

		// step4. 꼭대기부터 맨뒤 까지 내림차순 형태의 순열을 오름차순으로 처리
		int k = N - 1;
		while (i < k) { // i == k가 되면 swap 할 필요 없으므로 그 전까지만 돌아라
			swap(numbers, i++, k--);
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
