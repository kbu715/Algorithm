package com.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SW1954_Sol {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("res/input3.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // tc
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N*N
			int[][] map = new int[N][N];
			
			
			// 순 서 : 우 => 하 => 좌 => 상
			
			int dir = 1; //진행방향 값 (우, 하: 1 / 좌, 상: -1)
			
			// x = 0 인 라인, 즉 첫번째 행은 볼 필요가 없기 때무에 x=0
			int x = 0, y = -1; //초기 좌표 위치
			
			int cnt = 1; //칸에 넣을 숫자
			
			while(true) {
				
				// 1. 우(y 증가)
				for (int i = 0; i < N; i++) {
					y += dir; // -1 -> 0
					map[x][y] = cnt++;
				}
				// 2. 하(x 증가)
				N--; // 아래, 위인 경우 출력해야 되는 데이터 갯수가 하나 줄어 듦
				if(N == 0) {
					break;
				}
				for (int i = 0; i < N; i++) {
					x += dir; 
					map[x][y] = cnt++;
				}
				
				// 3. 방향값만 바꿔줌 (좌 / 상 은 dir값만 바꿔주면 해결)
				dir = dir * -1;
				
			}
			
			
			System.out.println("#" + tc);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.printf("%3d", map[i][j]);
				}
				System.out.println();
			}
		}
	}

}
