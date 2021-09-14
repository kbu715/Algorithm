package com.day1;

public class Bar {

	// 1.길이가 n인 막대(맨뒤에 파란색 막대): (n-1)cm + 1cm
	// 2.길이가 n인 막대(맨뒤에 노란색 막대): (n-1)cm + 1cm
	// 3.길이가 n인 막대(맨뒤에 빨간색 막대): (n-2)cm + 2cm
	
	public static void main(String[] args) { // 답 : 169?
		// 길이가 n인 막대를 만드는 방법의 수 d(n)
		//(1, 파란막대), (1, 노란막대), (2, 빨간막대)
		// 점화식? 중요해
			
		
		int N = 6;
		
		// Memo
		int[] d = new int[N+1];
		d[1] = 2; // 파란, 노란
		d[2] = 5; // 파파 파노 노노 노파 빨
		
		for (int i = 3; i <= N; i++) {
			d[i] = d[i-1] + d[i-1] + d[i-2]; // 이런걸 점화식...
		}
		
		System.out.println(d[N]);
		
	}

}
