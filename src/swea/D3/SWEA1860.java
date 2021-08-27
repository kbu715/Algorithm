package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 1860 진기의 최고급 붕어빵 D3
public class SWEA1860 {

	static int N, M, K; // N명, M초에 K개의 붕어빵 만듦

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String answer = "Possible";

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			ArrayList<Integer> times = new ArrayList<>(); // 도착시간 리스트

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				times.add(Integer.parseInt(st.nextToken()));
			}

			Collections.sort(times);

			boolean flag = false;

			for (int i = 0; i < N; i++) {
				int arrivalTime = times.get(i);
				int count = K * (arrivalTime / M); // 손님이 도착했을 때 만든 빵의 개수
				if (count < i + 1) {
					flag = true;
				}
			}

			if (flag)
				answer = "Impossible";
			System.out.println("#" + tc + " " + answer);

		}
	}

}
