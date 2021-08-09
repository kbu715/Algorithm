package com.day6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA1228_Sol {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/pw.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 길이
			StringTokenizer st = new StringTokenizer(br.readLine()); // 암호문을 읽어 공백기준으로 잘라 놓음
			LinkedList<String> list = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			} // 원본데이터 입력

			int M = Integer.parseInt(br.readLine()); // 명령어 갯수. 삽입할 작업 수
			st = new StringTokenizer(br.readLine()); // 명령어 분할

			// [I 3 2 12345 45678]
			for (int i = 0; i < M; i++) { // 명령어 횟수만큼 작업할 거임
				st.nextToken(); // I
				int index = Integer.parseInt(st.nextToken()); // 원본에 삽입할 인덱스 위치
				int num = Integer.parseInt(st.nextToken()); // num개의 숫자

				for (int j = index; j < index + num; j++) {
					list.add(j, st.nextToken());
				}
			}

			System.out.print("#" + tc + " ");

			for (int i = 0; i < 10; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}
	}

}
