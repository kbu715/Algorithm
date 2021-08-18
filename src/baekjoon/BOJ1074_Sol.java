package com.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Sol {

	static int N;
	static int cnt; // cnt: 몇번째 값인지 체크해주는 변수
	static int R;
	static int C;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		search((int) Math.pow(2, N), 0, 0); // 배열의 가로세로 크기, 방문을 시작하려는 x, y좌표
	}

	// 가로세로 크기가 n인 사각형에의 x, y 좌표에서 방문 시작
	private static void search(int n, int x, int y) {
		if (x == R && y == C) { // 원하는 대상 찾음
			System.out.println(cnt);
			return;
		}

		// x <= R && y <= C : 현재위치보다 방문하려는 값이 더 뒤쪽에 있고 -> 방문가능
		// R < (x + n) && C < (y + n): 방문탐색하는 영역안에 원하는 R,C가 들어있다면
		if (x <= R && y <= C && R < (x + n) && C < (y + n)) {
			// 영역 나누기
			int half = n / 2;
			search(half, x, y); // 1사분면
			search(half, x, y + half); // 2사분면
			search(half, x + half, y); // 3사분면
			search(half, x + half, y + half); // 4사분면
		} else { // 찾는 값이 탐색하려는 영역안에 없는 경우 => 다른 사분면에 있는 경우
			cnt += n * n; // n: 현재 위치에서 탐색해야 되는 크기
		}
	}
}
