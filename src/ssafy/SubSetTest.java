package com.memorize;

import java.util.Scanner;

// 입력받은 N개의 자연수들로 가능한 부분집합 구성 : 재귀+boolean배열

public class SubSetTest {

	static int N;
	static int[] input;

	static boolean[] flag;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = 3;//sc.nextInt();
		
		input = new int[N];//전체 수
		flag = new boolean[N];//선택, 비선택 여부 저장하는 배열
		
		for (int i = 0; i < N; ++i) {
			input[i] = i+1;//sc.nextInt();
		}//입력

		subset(0);		
	}

	private static void subset(int count) { // count: 현재까지 고려한 원소 수
		//하나의 부분집합이 완성되면 출력할 것
		if (count == N) {						
			for (int i = 0; i < N; ++i) {				
				System.out.print((flag[i] ? input[i] : "X") + " ");
			}
			System.out.println();
			return;
		}

		flag[count] = true;
		subset(count + 1);

		flag[count] = false;
		subset(count + 1);
	}

}
