package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백만장자 D2
public class SWEA1859 {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			long answer = 0;

			N = Integer.parseInt(br.readLine());
			int[] prices = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			answer = check(prices);

			System.out.println("#" + tc + " " + answer);
		}
	}

	// 1. 뒤에서부터 현재 최대값보다 큰값이 나올때까지 현재최대값에서 각 값을 뺀 값을 누적시킨다.
	// 2. 그리고 이 과정을 반복한다.
	private static long check(int[] prices) {

		int maxValue = prices[N - 1];
		long maxSum = 0;
		for (int i = N - 2; i >= 0; i--) {

			if (maxValue >= prices[i]) {
				maxSum += maxValue - prices[i];
			} else {
				maxValue = prices[i];
			}

		}
		return maxSum;
	}

}
