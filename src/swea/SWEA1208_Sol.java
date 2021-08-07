package com.day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SWEA1208 {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int cnt = sc.nextInt(); // 덤프횟수 1~1000

			int[] nums = new int[100]; // 가로 방향은 100
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			// 입력 확인
//			System.out.println(Arrays.toString(nums));

			// 평탄화 작업
			while (true) {
				Arrays.sort(nums); // 정렬하기

				int high = nums[99] - nums[0]; // 최고점과 최저점의 차이

				if (high <= 1 || cnt <= 0) { // 평탄화 완료 혹은 덤프횟수를 다 쓴 경우
					System.out.println("#" + tc + " " + high);
					break;
				}
				// 평탄화 완료가 아직이고 or 덤프횟수가 남은 경우
				cnt--;
				nums[99]--;
				nums[0]++;
			}
		}
	}
}