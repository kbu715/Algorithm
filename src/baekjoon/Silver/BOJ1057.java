package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 토너먼트 실버3
public class BOJ1057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int kNum = Integer.parseInt(st.nextToken());
		int lNum = Integer.parseInt(st.nextToken());
		int answer = 0;

		while (N >= 1) {

			answer++;
			if (Math.abs(kNum - lNum) == 1 && Math.max(kNum, lNum) % 2 == 0) {
				break;
			} else if (N == 1) {
				answer = -1;
				break;
			}

			// 붙어있지 않은경우
			if (kNum % 2 == 1) { // 홀수이면
				kNum /= 2;
				kNum += 1;
			} else
				kNum /= 2;
			if (lNum % 2 == 1) {
				lNum /= 2;
				lNum += 1;
			} else
				lNum /= 2;

			N /= 2;

		}

		System.out.println(answer);

	}

}
