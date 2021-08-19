package com.day13;

// 분할 정복 응용 - 같은 색 공간 만들기
/*
 * 여러개의 작은 단위 정사각형(크기 1) 공간들로 이루어진 커다란 정사각형 모양의 공간이 주어져 있고
 * 각 단위 정사각형 공간들은 하얀색 또는 초록색으로 칠해져 있다.
 * 
 * 주어진 정사각형 공간을 일정한 규칙에 따라 나누어 다양한 크기를 갖는 정사각형 모양의 하얀색 또는 
 * 초록색의 공간으로 만들려고 한다.
 * 
 * 입력으로 주어진 전체 공간의 한변의 길이 N과 전체 공간을 구성하는 각 단위 정사각형 공간의 색상
 * (하얀색 또는 초록색)이 주어질때 규칙에 따라 나누어진 하얀색 공간과 초록색 공간의 정사각형의 개수를
 * 구하는 프로그램을 작성하시오
 */
public class MakeSpaceTest {

	static int white, green;
	static int[][] spaces;

	public static void main(String[] args) {
		
		int n = 8;
		spaces = new int[][] {
			{1,1,0,0,0,0,1,1},
			{1,1,0,0,0,0,1,1},
			{0,0,0,0,1,1,0,0},
			{0,0,0,0,1,1,0,0},
			{1,0,0,0,1,1,1,1},
			{0,1,0,0,1,1,1,1},
			{0,0,1,1,1,1,1,1},
			{0,0,1,1,1,1,1,1},
		};
		cut(0, 0, n);
		System.out.println(white);
		System.out.println(green);
		
	}
	
	private static void cut(int r, int c, int size) {
		int sum = 0;
		for (int i = r; i < r+size; i++) {
			for (int j = c; j < c+size; j++) {
				sum += spaces[i][j];
			}
		}
		
		// 같은색인지 체크 // 기저조건!!!
		if(sum == size*size) { // 초록색
			green++;
		} else if(sum == 0) { // 하얀색
			white++;
		} else { // 색이 섞여 있음
			// 4분할하여 각각의 사각형 처리
			int half = size / 2;
			cut(r, c, half);
			cut(r, c+half, half);
			cut(r+half, c, half);
			cut(r+half, c+half, half);
		}
	}

}
