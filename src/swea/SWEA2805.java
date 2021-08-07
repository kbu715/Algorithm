package com.day3;

import java.io.FileInputStream;
import java.util.Scanner;

public class SWEA2805 {
	
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("res/input4.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt(); // N*N
			System.out.println(N);
			String[][] map = new String[N][N];
			
			sc.nextLine();
			
			// 입력
			for (int i = 0; i < N; i++) {
				map[i] = sc.nextLine().split("");
			}
			
			
			
			// 로직
			int total = 0;
			
			int C = N / 2; // 가운데줄
			
			// 가운데줄 처리
			for (int i = 0; i < N; i++) {
				total += Integer.parseInt(map[C][i]);
			}
			
			// 위에 부분
			for (int r = 0; r < C; r++) {
				for (int c = C-r; c <= C+r ; c++) {
					total += Integer.parseInt(map[r][c]);
				}
			}
			
			// 아래 부분
			for (int r = C+1; r < N ; r++) { 
				for (int c = C - (N-1-r) ; c <= C + (N-1-r) ; c++) {
					total += Integer.parseInt(map[r][c]);
				}
			}
			// 출력 
			System.out.println("#" + test_case + " " + total);
		}
	}
}