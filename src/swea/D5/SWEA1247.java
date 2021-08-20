package com.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최적경로 D5
public class SWEA1247 {

	static int N; // N명의 고객
	static int cx, cy, hx, hy; // 회사 좌표 // 집 좌표
	static Position[] selected; // 순열 좌표 배열
	static boolean[] flag;
	static Position[] list; // N명의 고객 위치를 담은 리스트
	static int minDistance = Integer.MAX_VALUE; // 최적의 이동거리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 회사
			cx = Integer.parseInt(st.nextToken());
			cy = Integer.parseInt(st.nextToken());
			// 집
			hx = Integer.parseInt(st.nextToken());
			hy = Integer.parseInt(st.nextToken());

			list = new Position[N];
			for (int i = 0; i < N; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[i] = new Position(a, b);
			}// 입력 끝
			
			selected = new Position[N];
			flag = new boolean[N];

			permutation(0);

			sb.append("#" + tc + " " + minDistance + "\n");
			minDistance = Integer.MAX_VALUE;
		}
		System.out.println(sb);
	}

	// 순열을 통해 최적 이동거리를 구하는 메소드
	private static void permutation(int cnt) {
		if (cnt == N) { // 순열 한개가 완성될때

			int total = 0;
			total += Math.abs(cx - selected[0].x) + Math.abs(cy - selected[0].y); // 처음 회사와 첫번째 고객과의 거리
			for (int i = 0; i < N - 1; i++) { // 고객들 차례대로 방문한 거리
				total += Math.abs(selected[i].x - selected[i + 1].x) + Math.abs(selected[i].y - selected[i + 1].y);
			}
			total += Math.abs(selected[N - 1].x - hx) + Math.abs(selected[N - 1].y - hy); // 마지막 고객과 집과의 거리
			minDistance = Math.min(minDistance, total);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (flag[i])
				continue;

			flag[i] = true;
			selected[cnt] = list[i];
			permutation(cnt + 1);
			flag[i] = false;

		}
	}

	// 좌표 클래스
	static class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
