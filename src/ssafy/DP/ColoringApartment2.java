package com.day1;

// n층의 아파트를 칠할 수 있는 방법의 수
// 아래층을 나타내는 변수 2개, 윗층을 나타내는 변수 2개
public class ColoringApartment2 {

	public static void main(String[] args) {
			int N = 8;
			int up_yellow = 0, up_blue = 0; //윗층
			int down_yellow = 1, down_blue = 1; //아래층 1층부터 시작.
			//초기값 지정. 아파트가 1층인 경우
			
			
			for (int i = 2; i <= N; i++) {
				// i층에 노란색을 칠할 수 있는 경우 : 아래층(i-1)이 노란색이거나 파란색이거나 다 됨!
				up_yellow = down_yellow + down_blue;
				
				up_blue = down_yellow;
				
				down_yellow = up_yellow;
				down_blue = up_blue;
			}
			
			System.out.println(up_yellow + up_blue); // 정답 55
	}

}
