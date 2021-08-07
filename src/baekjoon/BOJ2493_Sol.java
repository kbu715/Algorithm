package com.day5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//입력되는 탑들의 높이를 저장 -> 스택
public class BOJ2493_Solution { // top-level class

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Stack<Tower> stack = new Stack<Tower>();

		int num, height;
		int N = Integer.parseInt(br.readLine()); // 탑의 갯수
		// StringTokenizer : 기본적으로 공백을 기준으로 자른다. 일종의 주머니. 주머니 안에서 하나씩 꺼낸다
		StringTokenizer st = new StringTokenizer(br.readLine()); // 6 9 5 7 4

		// 입력 받은 값들을 하나씩 꺼내서 체크
		for (num = 1; num <= N; num++) {
			height = Integer.parseInt(st.nextToken());
//			System.out.println(height);

			// 스택을 조사 -> 스택안의 탑의 높이가 더 높아야함
			while (!stack.empty()) {
				if (stack.peek().height >= height) { // 신호를 받을 수 있음
					System.out.print(stack.peek().num + " ");
					break;
				}
				// 더 낮은 경우 -> 앞으로도 계속 못받아요
				stack.pop();

			}
			// while보다 먼저 체크하면 안됨
			// 처음에는 스택에 데이터가 있다가 조건에 안맞아서 pop pop pop이 되면 스택이 비는 경우가 생김
			// 즉, 스택에 값이 있어서 조사를 했는데 다 자기보다 낮아서 스택이 비게 된 경우.
			// 이런 경우가 존재하기 때문에 if문이 while문 보다 먼저 오면 안된다.
			if (stack.isEmpty()) {
				System.out.print(0 + " ");
			}
			stack.push(new Tower(height, num));
		}

	}

	// static inner class
	static class Tower {
		int height;
		int num;

		public Tower(int height, int num) {
			this.height = height;
			this.num = num;
		}
	}
}
