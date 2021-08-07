package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1940 {

	// 0: 현재속도 유지 1: 가속 2: 감속
	// 카의 이동거리를 구하자
	// 거리 = 속도 x 시간
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/rc.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // N회 N초동안

			// 거리
			int distance = 0;

			// 카의 속도
			int speed = 0; // 초기 속도 0m/s

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int C = Integer.parseInt(st.nextToken());

				// 가속도
				int accel = 0;
				if (C != 0 && st.hasMoreTokens()) {
					accel = Integer.parseInt(st.nextToken()); // 가속도 1m/s2 or 2m/s2
				}

				// 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0 m/s 가 된다.
				switch (C) {
				case 0: // 유지
					distance += speed;
					break;
				case 1: // 가속
					speed += accel;
					distance += speed;
					break;
				case 2: // 감속
					speed -= accel;
					if (speed < 0) {
						speed = 0;
					}
					distance += speed;
					break;

				}
			}

			System.out.println("#" + tc + " " + distance);
		}
	}

}
