package com.day1;

import java.util.Scanner;

//동적계획법 DP : 그리디 알고리즘과 같이 최적화 문제를 해결하는 알고리즘
// 재귀를 잘 이해해야 잘한다.

//다음의 요건을 충족해야함
//1. 중복 부분문제 구조 (Overlapping subproblems) 
//2. 최적 부분문제 구조 (Optimal Substructure) : 최적화의원칙을 만족해야함(어떤문제의 해가 최적일때 그 문제의 작은 문제들도 최적이어야 함)

public class DP1_FibonacciTest1 {

	static long totalCount1, totalCount2;
	static long[] call1, call2, memo;
	
	private static long fibo1(int n) {
		totalCount1++;
		call1[n]++;
		if(n<2) return n;
		return fibo1(n-1)+fibo1(n-2);
	}
	
	private static long fibo2(int n) {
		totalCount2++;
		call2[n]++;
		if(n>=2 && memo[n] == 0) {
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		call1 = new long[N+1];
		call2 = new long[N+1];
		memo = new long[N+1]; // 자동으로 0 초기화 : 메모되지 않은 상태로 사용할 것!
		
		// 계산할 수 없는 기본값들 초기화
		
		memo[0] = 0;
		memo[1] = 1;
		
		// 메모버전
		System.out.println(fibo2(N));
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo2("+i+") : " +call2[i]);
		}
		System.out.println("fibo2 callcount : " +totalCount2);
		
		// 비메모버전
		System.out.println(fibo1(N));
		for (int i = 0; i <= N; i++) {
			System.out.println("fibo1("+i+") : " +call1[i]);
		}
		System.out.println("fibo1 callcount : " +totalCount1);
				
	}

}
