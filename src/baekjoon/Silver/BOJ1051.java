package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 정사각형 실버3
public class BOJ1051 {

	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int R = N >= M ? N : M;
		int max = 0;
		for (int i = 1; i <= R; i++) {
			int area = getMaxSquareArea(i);
			max = Math.max(max, area);
		}

		System.out.println(max);

	}

	private static int getMaxSquareArea(int R) { // range: range x range area
		if (R == 1) {
			return 1;
		}
		for (int i = 0; i < N - R + 1; i++) {
			for (int j = 0; j < M - R + 1; j++) {
				if (map[i][j] == map[i + R - 1][j] && map[i + R - 1][j] == map[i + R - 1][j + R - 1]
						&& map[i + R - 1][j + R - 1] == map[i][j + R - 1] && map[i][j + R - 1] == map[i][j]) { // 네 꼭지점
					return R * R;
				}
			}
		}
		return 0;
	}

}
