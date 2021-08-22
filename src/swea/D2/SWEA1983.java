package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 조교의 성적 매기기 D2
public class SWEA1983 {

	static int N;
	static int K;
	static int[][] scores;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String answer = "A-";

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 알고싶은 학생 번호
			scores = new int[N][3];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					scores[i][j] = Integer.parseInt(st.nextToken());

				}
			}

			answer = search(scores, K);

			System.out.println("#" + tc + " " + answer);
		}

	}

	private static String search(int[][] scores, int k) {

		double key = getTotalScores(scores[k - 1]);
		int keyIndex = 0;

		double[] totalScores = new double[N];

		for (int i = 0; i < N; i++) {
			totalScores[i] = getTotalScores(scores[i]);
		}

		Arrays.sort(totalScores);

		System.out.println(Arrays.toString(totalScores));

		for (int i = 0; i < totalScores.length; i++) {
			if (totalScores[i] == key) {
				keyIndex = i;
			}
		}

		return getGPA(N - 1 - keyIndex); // 오름차순이기때문에 내림차순으로 하기위해 인덱스를 거꾸로 처리

	}

	private static String getGPA(int keyIndex) {
		switch (keyIndex / (N / 10)) {
		case 0:
			return "A+";
		case 1:
			return "A0";
		case 2:
			return "A-";
		case 3:
			return "B+";
		case 4:
			return "B0";
		case 5:
			return "B-";
		case 6:
			return "C+";
		case 7:
			return "C0";
		case 8:
			return "C-";
		case 9:
			return "D0";
		}
		return null;
	}

	private static double getTotalScores(int[] scores) {
		double total = scores[0] * 0.35 + scores[1] * 0.45 + scores[2] * 0.2;
		return total;
	}

}
