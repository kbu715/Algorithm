package com.ssafy.stackandqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 스택 이용한 브라우저 뒤로가기 앞으로가기
public class BrowserTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = null;
		String input = null;
		String current = "http://www.ssafy.com";

		Stack<String> back = new Stack<String>();
		Stack<String> forward = new Stack<String>();

		while (true) {
			input = br.readLine();
			if (input.charAt(0) == 'Q')
				break;

			st = new StringTokenizer(input, " ");

			switch (st.nextToken()) {
			case "V": // Visit
				forward.clear();
				back.push(current);
				current = st.nextToken();
				System.out.println(current);
				break;
			case "B": // Back
				if (back.isEmpty()) {
					System.out.println("Ignored.");
				} else {
					forward.push(current);
					current = back.pop();
					System.out.println(current);
				}
				break;
			case "F": // Forward
				if (forward.isEmpty()) {
					System.out.println("Ignored.");
				} else {
					back.push(current);
					current = forward.pop();
					System.out.println(current);
				}
				break;
			}
		}
	}

}

// back stack
// forward stack 
// 두개 사이에 current가 있다고 생각
