package com.day13;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA11315_Sol {
	// 8방 접근할 때 사용할 위치 변화값. 상, 우상, 우, 우하, 하, 좌하, 좌, 좌상
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int a;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();// testcase 수. 4

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();// 배열 가로세로 크기
			char[][] map = new char[N][N];

			// 1.입력
			for (int i = 0; i < N; i++) {
				String line = sc.next();// 한줄 읽기. ..o..
				map[i] = line.toCharArray();
			} // 입력완료

			// System.out.println(Arrays.deepToString(map));//2차원이라서

			boolean flag = false;// 오목여부체크

			// 2.한칸씩 체크
			outter: for (int i = 0; i < N; i++) {// 행
				for (int j = 0; j < N; j++) {// 열

					if (map[i][j] == 'o') {// 돌발견 ->8방 체크해야 함
						for (int k = 0; k < 8; k++) {// 8방 체크. 추가로 4개가 더 발견되면 성공
							for (int cnt = 1; cnt <= 4; cnt++) {
								int nx = i + dx[k] * cnt;
								int ny = j + dy[k] * cnt;

								if (nx < 0 || ny < 0 || nx >= N || ny >= N) {// 배열 안쪽
									break;
								} else if (map[nx][ny] != 'o') {
									break;
								}

								if (cnt == 4) {// 연속해서 한방향으로 돌이 있음
									flag = true;
									break outter;
								} // if
							} // 4개 체크
						} // 8방 체크
					} // 돌발견
				} // 열
			} // 행
			sb.append("#" + tc + " " + (flag ? "YES" : "NO") + "\n");
		}

		System.out.println(sb);

	}

}
