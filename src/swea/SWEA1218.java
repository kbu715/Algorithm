package com.day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/bracket.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int L = Integer.parseInt(br.readLine().trim()); // Length
			String str = br.readLine();

			int answer = 0;
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < L; i++) {
				char c = str.charAt(i);
				// 닫힌 괄호 종류에 맞는 쌍 유효성 여부를 확인하여 제거
				// stack이 비어있지 않은 상태에서 peek() 가능
				if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else if (c == '>' && !stack.isEmpty() && stack.peek() == '<')
					stack.pop();
				else // 여는 괄호일때 or 닫는 괄호 짝이 맞지 않은 경우 닫는 괄호도 stack push
					stack.push(c);
			}

			if (stack.isEmpty()) {
				// 스택이 모두 비워진 경우
				answer = 1;
			} else {
				answer = 0;
			}

			// 정답 출력
			System.out.println("#" + tc + " " + answer);
		}
	}

}
