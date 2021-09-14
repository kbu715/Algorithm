package com.day1;

// n층의 아파트를 칠할 수 있는 방법의 수 : d[n][2] = ( d[n][0] + d[n][1] )
// d[n][0] : n층을 노란색으로 칠할 수 있는 가지수, d[n][1] : 파란색
public class ColoringApartment {

	public static void main(String[] args) {
			int N = 8;
			int[][] d = new int[N+1][2];
			int yellow = 0, blue = 1;
			
			//초기값 지정. 아파트가 1층인 경우
			
			d[1][yellow] = 1; //노랑
			d[1][blue] = 1; //파랑
			
			for (int i = 2; i <= N; i++) {
				d[i][yellow] = d[i-1][yellow] + d[i-1][blue];
				d[i][blue] = d[i-1][yellow];
			}
			
			System.out.println(d[N][0] + d[N][1]); // 정답 55
	}

}
