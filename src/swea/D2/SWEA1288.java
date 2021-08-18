package com.day12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//새로운 불면증 치료법 - D2
public class SWEA1288 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String S = br.readLine();
			int N = Integer.parseInt(S);

			// 확인 배열
			boolean check[] = new boolean[10];

			// 입력받은 N에 계속 곱해주는 변수
			int var = 1;

			// 확인 배열에 값이 있으면 1씩 증가
			int cnt = 0;

			while (true) {
				// 값이 있는 경우 인덱스 위치 배열 1씩 증가
				for (int i = 0; i < S.length(); i++) {
					// 한글자씩 정수로 변환하여 확인
					int tmp = Integer.parseInt(S.substring(i, i + 1));
					if (check[tmp] == false) {
						cnt++;
						check[tmp] = true;
					}
				}

				// 10개를 모두 봤다
				if (cnt == 10)
					break;

				var++;
				S = Integer.toString(N * var);
			}

			sb.append("#" + tc + " " + S + "\n");

		}
		System.out.println(sb);
	}

}
