package com.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 탑
public class BOJ2493 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Stack<int[]> top = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());

			while (!top.isEmpty()) {
				if (top.peek()[0] < height) // 왼쪽 옆에 있는 탑이 현재 탑의 높이보다 작으면, 어떠한 신호도 수신할 수 없으므로 pop!
					top.pop();
				else { // 현재 탑의 높이보다 크다면, 해당 탑의 번호를 출력한다.
					System.out.print(top.peek()[1] + " ");
					break;
				}
			}

			if (top.empty()) // 탑이 비었다면 0을 출력한다.
				System.out.print("0 ");
			top.push(new int[] { height, i + 1 }); // 탑의 높이와 탑의 인덱스 순
		}

	}

}