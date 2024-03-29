package com.ssafy.algoclass.day2;

public class HanoiTest {

	private static void hanoi(int n , int start, int temp, int dest) {
		
		if(n==0) return;
		
		// 자신의 위쪽의 n-1개 원판 들어내기 : 임시 기둥으로 옮기기
		hanoi(n-1, start, dest, temp);
		// 자신의 원판 옮기기 : 목적기둥
		System.out.println(n+"번 블록:"+start+"기둥에서 > "+dest+"기둥으로");
		// 들어냈던 임시기둥의 n-1개 원판 자신위에 쌓기 : 목적기둥으로 옮기기
		hanoi(n-1, temp, start, dest);
	}
	
	public static void main(String[] args) {
		hanoi(3, 1, 2, 3); //시작기둥: 1, 임시기둥: 2, 목적기둥: 3
	}

}
