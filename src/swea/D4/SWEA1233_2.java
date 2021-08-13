package com.day8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

//리프노드(자식이 없는 노드: N/2+1 ~ N)는 숫자이어야 하고
//루트노드나 내부노드(자식이 있음: 1~N/2) 연산자이어야 함

public class SWEA1233_2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/tree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());// N
			int result = 0;

			for (int i = 0; i < N; i++) {
				// 1 - 2 3
				String[] str = br.readLine().split(" ");
				if (i < N / 2) {// 내부노드->연산자 이어야 됨
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						result = 1;

					} else {
						result = 0;
					}
				} else {// 리프노드->숫자이어야 함
					if (str[1].equals("+") || str[1].equals("-") || str[1].equals("*") || str[1].equals("/")) {
						result = 0;
					}
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}
}
