package com.memorize;

import java.util.Arrays;

public class PermutationTest {
	
	// 1,2,3
	// 3자리수 순열
	// 3P3 = 3!= 6
	
	static int N=3,R=3;//nPr
	static int[] numbers;	
	static int[] selected, input;
	static boolean[] flag;
	
	public static void main(String[] args) {
		input = new int[N];
		selected = new int[R];
		flag = new boolean[N];//1,2,3

		/*
		for (int i = 0; i < N; i++) {
			input[i] = i+1;
		}
		*/
		input = new int[] {1,2,3}; // 입력 대신 초기화 해서 실험

		permutation(0);//0: 0번째 위치에 넣을 숫자 뽑으러. 뽑은 숫자 갯수
	}
	

	public static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(selected));
			return;
		}//basis. 종료파트
		
		for(int i=0; i<N; ++i) {
			if(!flag[i]){ //사용 안했음		
			
				flag[i] = true;
				selected[cnt] = input[i];//cnt 위치에 i값 저장
				permutation(cnt+1);//다음 위치에 넣을 값 뽑으러 보냄				
				flag[i] = false;
			}
		}
	}
}

