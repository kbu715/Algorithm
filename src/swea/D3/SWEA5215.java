package com.day8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 햄버거 다이어트 D3
public class SWEA5215 {

	static int N; // Number
	static int L; // Limit
	static boolean flag[]; // 부분집합에 포함되는지 여부
	static int[][] list;
	static int scoreTotal;
	static int calTotal;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int tc = 1; tc <= T; tc++) {
			String[] info = br.readLine().split(" "); // 재료의 수, 제한 칼로리 정보

			N = Integer.parseInt(info[0]); // 재료의 수
			L = Integer.parseInt(info[1]); // 칼로리 제한

			list = new int[N][2];

			String[] ingredientInfo;
			int score;
			int cal;
			for (int i = 0; i < N; i++) {
				ingredientInfo = br.readLine().split(" "); // 재료정보
				score = Integer.parseInt(ingredientInfo[0]);
				cal = Integer.parseInt(ingredientInfo[1]);
				list[i][0] = score;
				list[i][1] = cal;
			}

			scoreTotal = 0;
			calTotal = 0;
			max = 0;
			flag = new boolean[N];
			subset(0);

			System.out.println("#" + tc + " " + max); // 출력
		}
	}

	private static void subset(int count) {

		if (count == N) { // 하나의 부분집합이 완성되었을때
			for (int i = 0; i < N; ++i) {
				if (flag[i]) {
					calTotal += list[i][1];
					if (calTotal > L) {
						break;
					}
					scoreTotal += list[i][0];
				}
			}
			if (max < scoreTotal) { // 최대값이면서 칼로리제한 지키는 값을 찾는다.
				max = scoreTotal;
			}
			scoreTotal = 0; // 초기화
			calTotal = 0;
			return;
		}

		flag[count] = true;
		subset(count + 1);

		flag[count] = false;
		subset(count + 1);
	}

}
