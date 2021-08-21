package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시각 덧셈 D2
public class SWEA1976 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());
			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());

			int h = (h1 + h2) % 12 + (m1 + m2) / 60;

			int m = (m1 + m2) % 60;

			System.out.println("#" + tc + " " + h + " " + m);

		}
	}

}
