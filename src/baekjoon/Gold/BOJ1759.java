package com.day15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 암호만들기
public class BOJ1759 {

	static int L; // L개로 구성
	static int C; // C개의 문자가 주어 졌을때
	static String[] selected;
	static String[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		input = new String[C];
		selected = new String[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			input[i] = st.nextToken();
		} // 입력끝

		Arrays.sort(input); // 정렬해줘야 출력할때 정렬되서 나온다.

		comb(0, 0);

	}

	private static void comb(int cnt, int start) {
		if (cnt == L) { // 한 조합 뽑힘

			if (check(selected)) {
				Arrays.sort(selected);
				for (int i = 0; i < L; i++) {
					System.out.print(selected[i]);
				}
				System.out.println();
			}

			return;
		}

		for (int i = start; i < C; ++i) {
			selected[cnt] = input[i];
			comb(cnt + 1, i + 1);
		}
	}

	private static boolean check(String[] selected) {
		int vCnt = 0;
		int cCnt = 0;
		for (int i = 0; i < L; i++) {
			if ("aeiou".contains(selected[i])) { // 모음이면 모음카운트 ++
				vCnt++;
			} else
				cCnt++;
		}

		if (vCnt >= 1 && cCnt >= 2) {
			return true;
		} else
			return false;
	}

}
