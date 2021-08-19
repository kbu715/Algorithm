package com.day13;

import java.util.Scanner;

// Backtracking
// 같은 행에 두지 않는 방식
// N개의 퀸을 위협적이지 않게 놓는 모든 경우의 수
public class NQueenTest2 {

	static int N, cnt;
	static int[] col;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N개의 Queen

		col = new int[N + 1]; // 한 행 하나의 퀸을 위한 퀸들의 열 인덱스 배열 (Q1, Q2, ...)

		cnt = 0;

		setQueens(1);
		System.out.println("경우의 수: " + cnt);
	}

	private static void setQueens(int rowNo) {
		if (rowNo > N) { // 마지막 행까지 다 둔 경우
			cnt++; // 경우의 수 ++
			return;
		}

		// 현재 퀸 1열부터 N열까지 놓아보기
		// 놓았으면 다음 퀸 놓으러 가기
		for (int i = 1; i <= N; i++) { // 1행부터 쓴다.
			col[rowNo] = i; // i열에 놓아보기
			// 유망여부 체크: rowNo-1행까지 유망한지 체크
			if (isAvailable(rowNo)) { // 가능하면 다음 퀸으로.
				setQueens(rowNo + 1);				
			}
		}
	}

	private static boolean isAvailable(int rowNo) { // rowNo: 현재 검사하려는 퀸
		// 현재퀸(rowNo)가 for문을 돌면서 이전퀸들과 유망여부 체크
		for (int k = 1; k < rowNo; k++) { // k: 이전 퀸
			if (col[rowNo] == col[k] || Math.abs(col[rowNo] - col[k]) == (rowNo - k))
				// 둘이 같은 열인지 보고 열과 행의 차이가 같으면 대각선에 위치한것이므로 유효하지 않다.
				return false;
		}
		return true;
	}

}
