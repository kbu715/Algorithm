package com.day11;

import java.util.Scanner;

// 봉지의 수를 최소화 하려면 최대한 5kg 봉지로 구성해야 함 -> 먼저 체크

public class BOJ2839_Sol {

//	public static void main(String[] args) {
//
//		int answer = 0; // 총 봉지 갯수. 답
//		int bag3 = 0; // 3kg 봉지 갯수
//
//		Scanner sc = new Scanner(System.in);
//
//		int N = sc.nextInt(); // 만들어야 하는 무게
//
//		while (N % 5 != 0 && N >= 0) { // n이 5kg 봉지로 해결이 안되는 경우
//
//			bag3++; // 3kg봉지 사용
//			N -= 3; // 전체 무게 감소
//
//		}
//		// N이 5kg 봉지로 해결이 되는 경우, or N이 음수인 경우
//		answer = (N < 0) ? -1 : bag3 + N / 5;
//
//		System.out.println(answer);
//	}

	public static void main(String[] args) {

		int answer = 0; // 총 봉지 갯수. 답
		int bag3 = 0; // 3kg 봉지 갯수

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 만들어야 하는 무게

		while (true) {
			if (N % 5 == 0) { // n이 5kg 봉지로 해결이 되는 경우
				System.out.println(N / 5 + bag3);
				break;
			} else { // n이 5kg봉지로 해결이 안되는 경우
				bag3++;
				N -= 3;
			}
			if (N < 0) {
				System.out.println(-1);
				break;
			}
		}

		sc.close();

	}

}
