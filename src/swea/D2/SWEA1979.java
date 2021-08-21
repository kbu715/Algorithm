package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 어디에 단어가 들어갈 수 있을까 D2
public class SWEA1979 {

	static String[][] map;
	static int N;
	static int K;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new String[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().split(" ");
			}
			answer = 0;
			check(K);

			sb.append("#" + tc + " " + answer + "\n");

		}
		System.out.println(sb);
	}

	private static void check(int K) {
		// 가로 검색
		for (int i = 0; i < N; i++) { // 행

			for (int j = 0; j <= N - K; j++) { // 열
				int sum = 0;
				for (int l = 0; l < K; l++) { // K번반복
					sum += Integer.parseInt(map[i][j + l]);
				}
				if (sum == K && checkSide(i, j - 1) && checkSide(i, j + K)) {
					answer++;
				}
			}

		}

		// 세로 검색
		for (int i = 0; i < N; i++) { // 열

			for (int j = 0; j <= N - K; j++) { // 행
				int sum = 0;
				for (int l = 0; l < K; l++) { // K번 반복
					sum += Integer.parseInt(map[j + l][i]);
				}
				if (sum == K && checkSide(j - 1, i) && checkSide(j + K, i)) {
					answer++;
				}
			}

		}

	}

	private static boolean checkSide(int r, int c) {
		if (r == -1 || r == N) {
			return true;
		} else if (c == -1 || c == N) {
			return true;
		} else {
			return map[r][c].equals("0");
		}
	}

}
