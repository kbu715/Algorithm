package com.ssafy.afterclass;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
// 쇠막대기 자르기
public class SWEA5432 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/sample_input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		int numOfLines = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			int cnt = 0; // 조각난 개수
			String str = br.readLine();
			// '()' 레이저를 '@'으로 치환
			str = str.replace("()", "@");
			char[] temp = str.toCharArray();

			// 입력 확인
//			System.out.println(Arrays.toString(temp));

			for (char c : temp) {
				switch (c) {
				case '(':
					numOfLines++;
					break;
				case ')':
					cnt += 1; // 라인 하나 끝나면 +1
					numOfLines--;
					break;
				case '@':
					cnt += numOfLines; // 레이저 만나면 라인 수 만큼 증가
					break;
				}
			}

			sb.append("#" + test_case);
			sb.append(" ");
			sb.append(cnt);
			System.out.println(sb.toString());
		}

	}

}

/*
 * 메모
 * 
 * '(' 만나면 라인 하나 추가
 * ')' 만나면 라인 끝 => 카운트++ AND 라인수--
 * '@' 만나면 라인 수만큼 카운트 증가
 * replace 이용하여 '()'를 '@'로 치환 
 * 이렇게 해야 안헷갈려
 */ 
