package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 간단한 압출풀기 D2
public class SWEA1946 {

	static String[][] compressed;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int N = Integer.parseInt(br.readLine());

			compressed = new String[N][];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				String s = st.nextToken();
				String n = st.nextToken();

				compressed[i] = new String[] { s, n };

			}

			System.out.println("#" + tc);
			uncompress(compressed);
		}
	}

	private static void uncompress(String[][] compressed) {
		int cnt = 0;
		for (int i = 0; i < compressed.length; i++) {

			for (int j = 0; j < Integer.parseInt(compressed[i][1]); j++) {
				System.out.print(compressed[i][0]);
				cnt++;
				if (cnt == 10) {
					System.out.println();
					cnt = 0;
				}
			}
		}
		System.out.println();
	}

}
