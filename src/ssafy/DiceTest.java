package com.ssafy.pandc;
// 중복 순열 // 중복 조합 // 순열 // 조합
import java.util.Arrays;
import java.util.Scanner;

public class DiceTest {

	// numbers: 순열 저장 배열
	static int N, numbers[], totalCnt;
	static boolean[] isSelected; // 인덱스에 해당하는 숫자가 사용 중인지 저장하는 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();

		numbers = new int[N];

		switch (M) {
		case 1: // 주사위 던지기 1: 중복순열
			dice1(0);
			break;
		case 2: // 주사위 던지기 2: 순열
			isSelected = new boolean[7];
			dice2(0);
			break;
		case 3: // 주사위 던지기 3: 중복조합
			dice3(0, 1);
			break;
		case 4: // 주사위 던지기 4: 조합
			dice4(0, 1);
			break;
		default:
			break;
		}

		System.out.println("경우의 수 : " + totalCnt);
	}
	// 중복 순열

	private static void dice1(int cnt) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {

			numbers[cnt] = i;
			dice1(cnt + 1);
		}
	}

	// 순열
	private static void dice2(int cnt) {
		if (cnt == N) {
			// 순열의 경우의 수가 하나씩 완성될 때마다 토탈카운트 up!
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= 6; i++) {
			// 중복 체크
			if (isSelected[i])
				continue;
			numbers[cnt] = i;
			isSelected[i] = true;

			dice2(cnt + 1);
			isSelected[i] = false;
		}
	}

	// 중복 조합
	private static void dice3(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice3(cnt + 1, i); // 현재 선택한 수부터 처리하도록
		}
	}

	// 조합
	private static void dice4(int cnt, int start) {
		if (cnt == N) {
			totalCnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = start; i <= 6; i++) {
			numbers[cnt] = i;
			dice4(cnt + 1, i + 1);
		}
	}

}
