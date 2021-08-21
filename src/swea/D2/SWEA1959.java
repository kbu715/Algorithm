package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 두개의 숫자열 D2
public class SWEA1959 {

	static int T;
	static int max;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			max = 0;
			getMax(A, B);

			System.out.println("#" + tc + " " + max);

		}
	}

	private static void getMax(int[] a, int[] b) {
		int al = a.length;
		int bl = b.length;

		int sum = 0;

		if (al > bl) {
			for (int i = 0; i < N - M + 1; i++) {
				sum = 0;
				for (int j = 0, k = i; j < bl; j++, k++) {
					sum += a[k] * b[j];

				}
				max = Math.max(max, sum);
			}

		} else {
			for (int i = 0; i < M - N + 1; i++) {
				sum = 0;
				for (int j = 0, k = i; j < al; j++, k++) {
					sum += b[k] * a[j];
				}
				max = Math.max(max, sum);
			}

		}

	}

}
