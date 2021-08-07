package com.day5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SWEA1861_Solution {

	static int[][] room; // data
	static int[][] visit; // 방문 배열. 이미 방문한 칸은 다시 방문하지 않도록 하려고

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N;

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/rect.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			room = new int[N][N];
			visit = new int[N][N]; // room 배열의 특정위치가 방문이 되었는지 체크하는 목적

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = sc.nextInt();
				}
			}

			// 한칸씩 조사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visit[i][j] == 0) { // 아직 방문 안한 칸(i,j)
						check(i, j); // i, j 위치에서부터 최장거리 계산
					}
				}
			}
			// 찾기
			int max = -1; // 최장길이
			int no = 0; // 방번호

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max < visit[i][j]) {
						max = visit[i][j]; // 길이
						no = room[i][j]; // 방번호
					} else if (max == visit[i][j]) {
						no = Math.min(no, room[i][j]);
					}
				}
			}

			System.out.println("#" + tc + " " + no + " " + max);

		}
	}

	// i, j 위치에서부터 4방 탐색을 하면서 최장 거리 계산하는 메소드.
	// i, j 위치에서부터 갈 수 있는 최대 거리가 visit 배열의 동일한 위치에 저장됨 !!!
	// 처음 시작하는 칸은 1로 시작.
	private static void check(int i, int j) {
		visit[i][j] = 1;

		for (int k = 0; k < 4; k++) { // 상 하 좌 우 탐색
			int nx = i + dx[k];
			int ny = j + dy[k];

			if (!inRange(nx, ny))
				continue;
			if (room[nx][ny] == room[i][j] + 1) {
				check(nx, ny);
				visit[i][j] = visit[nx][ny] + 1; 
			}
		}
	}

	private static boolean inRange(int nx, int ny) {
		return (nx >= 0 && nx < N && ny >= 0 && ny < N);
	}

}
