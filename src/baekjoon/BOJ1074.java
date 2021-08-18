package com.day11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074 {

	static int N;
	static int cnt;
	static int r;
	static int c;
	static int[] dx = { 0, 0, 1, 1 }; // z 방향으로 이동하기 위한 변동값 배열
	static int[] dy = { 0, 1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		search((int) Math.pow(2, N), 0, 0);

	}

	private static void search(int n, int row, int col) {
		if (n == 2) { // 최소 2x2 기저조건
			for (int i = 0; i < 4; i++) {
				int nr = row + dx[i];
				int nc = col + dy[i];
				if (nr == r && nc == c) {
					System.out.println(cnt);
					break;
				}
				cnt++;
			}
			return;
		}
		int mid = n / 2;
		int size = mid * mid; // 1사분면 사이즈 => 그만큼 cnt++

		if (r < row + mid && c < col + mid) {
			search(mid, row, col); // 왼쪽 상단
		} else if (r < row + mid && c >= col + mid) {
			cnt += size * 1;
			search(mid, row, col + mid); // 오른쪽 상단
		} else if (r >= row + mid && c < col + mid) {
			cnt += size * 2;
			search(mid, row + mid, col); // 왼쪽 하단
		} else {
			cnt += size * 3;
			search(mid, row + mid, col + mid); // 오른쪽 하단
		}
	}

}
