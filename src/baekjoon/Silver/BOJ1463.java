package com.day2;

import java.util.Scanner;

public class BOJ1463 {

//	정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//	X가 3으로 나누어 떨어지면, 3으로 나눈다.
//	X가 2로 나누어 떨어지면, 2로 나눈다.
//	1을 뺀다.
//	정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] D = new int[N+1];
		
		// 초기값
		D[0] = 0;
		D[1] = 0;
		
		for (int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			// 3으로 나뉘는 경우
			if(i%3==0) min = Math.min(D[i/3] + 1, min);
			// 2로 나뉘는 경우
			if(i%2==0) min = Math.min(D[i/2] + 1, min);
			// 그외
			min = Math.min(D[i-1] + 1, min);
			
			D[i] = min; // memoization
		}
		
		System.out.println(D[N]);
		sc.close();
	}

}
