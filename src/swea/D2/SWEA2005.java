package swea;

import java.util.Scanner;

// 파스칼의 삼각형 D2

public class SWEA2005 {

	static int[][] map;
	static int N;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][];

			paintMap(N);
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}

		sc.close();

	}

	private static void paintMap(int n) {

		if (n == 1) {
			map[0] = new int[] { 1 };

		} else if (n == 2) {
			map[0] = new int[] { 1 };
			map[1] = new int[] { 1, 1 };

		} else if (n >= 3) {

			map[0] = new int[] { 1 };
			map[1] = new int[] { 1, 1 };

			for (int i = 2; i < n; i++) {
				map[i] = new int[i + 1];
				for (int j = 0; j <= i; j++) {
					if (j >= 1 && j <= i - 1) {
						map[i][j] = map[i - 1][j] + map[i - 1][j - 1];
					}
					map[i][0] = 1; // 맨왼쪽은 항상 1
					map[i][i] = 1; // 맨오른쪽은 항상 1
				}
			}
		}

	}

}
