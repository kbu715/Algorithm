package com.day5;

import java.util.ArrayList;

// 1. 실패함수(부분 일치 테이블) 만들기
// 2. 완성된 실패함수를 참조해서 텍스트와 패턴을 비교

public class KMPTest {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		char[] text = br.readLine().toCharArray();

		char[] text = { 'a', 'a', 'a', 'a', 'a', 'a', 'b' };
		char[] pattern = { 'a', 'a', 'a' };

		int tlen = text.length, plen = pattern.length; // 길이

		// 1. 실패함수 만들기(pattern 이용해서 길이만큼 작성)
		int[] pi = new int[plen]; // 패턴포인터를 어디로 옮겨야 하는지 인덱스 저장

		// i: 접미사 포인터, j: 접두사 포인터
		for (int i = 1, j = 0; i < plen; i++) {

			while (pattern[i] != pattern[j] && j > 0) { // 불일치 했을때
				j = pi[j - 1];
				if (pattern[i] == pattern[j]) { // 일치했을때
					pi[i] = ++j;
				}
			}
		}

		// 2. 텍스트와 패턴비교
		int cnt = 0; // 일치하는 횟수
		ArrayList<Integer> list = new ArrayList<>(); // 패턴일치 발생한 시작 인덱스

		// i: 텍스트 인덱스. j: 패턴 인덱스
		for (int i = 0, j = 0; i < tlen; i++) {
			while (text[i] != pattern[j] && j > 0) { // 일치하지 않을 때
				j = pi[j - 1];
			}

			if (text[i] == pattern[j]) {// 일치
				if (j == plen - 1) { // 패턴문자열 끝. 일치하는 경우임.
					cnt++;
					list.add((i + 1) - plen); // 패턴일치가 발생한 텍스트의 시작 인덱스
					j = pi[j]; // j위치까지는 맞은거니까 포인터를 j위치로 옮김.
				} else {
					j++;
				}
			}
		}
		System.out.println(cnt); // 일치횟수
		if (cnt > 0) {
			System.out.println(list);
		}
	}

}
