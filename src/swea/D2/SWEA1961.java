package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 배열 회전 D2
public class SWEA1961 {

	static int N;
	static int[][] map;
	static int[][] map90;
	static int[][] map180;
	static int[][] map270;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			map90 = new int[N][N];
			map180 = new int[N][N];
			map270 = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			map90 = rotate90(map);
			map180 = rotate90(map90);
			map270 = rotate90(map180);

			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(map180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(map270[i][j]);
				}
				System.out.println();
			}

		}
	}

	private static int[][] rotate90(int[][] map) {
		int[][] copy = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				copy[r][c] = map[N - 1 - c][r];
			}
		}

		return copy;
	}

}
