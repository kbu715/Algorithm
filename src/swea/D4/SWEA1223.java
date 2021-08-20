package com.day14;

import java.util.*;
// 구글링
// 계산기 D4
public class SWEA1223 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			String s = sc.next();
			Stack<Character> ops = new Stack<>();
			String r = "";
			for (int i = 0; i < n; i++) {
				char c = s.charAt(i);
				if (c - '0' >= 0 && c - '0' <= 9) { // 숫자면
					r += String.valueOf(c);
				} else { // 문자면
					if (ops.isEmpty()) {
						ops.push(c);
					} else {
						if (getPriority(ops.peek()) >= getPriority(c)) { // 들어오는 연산자가 우선순위가 낮으면 stack에서 그 전 연산자 뽑고 push
							r += String.valueOf(ops.pop());
							ops.push(c);
						} else { // 들어오는 연산자가 우선순위가 높으면 스택에 넣어놓는다.
							ops.push(c);
						}
					}
				}
			}
			while (!ops.isEmpty()) {
				r += String.valueOf(ops.pop());
			}

			Stack<Integer> nums = new Stack<>();
			for (int i = 0; i < r.length(); i++) {
				char c = r.charAt(i);
				if (c - '0' >= 0 && c - '9' <= 0) // 숫자면
					nums.push(c - '0');
				else { // 연산자면 계산해서 다시 num 스택에 push
					int tmp1 = nums.pop();
					int tmp2 = nums.pop();
					if (c == '*')
						nums.push(tmp1 * tmp2);
					else if (c == '+')
						nums.push(tmp1 + tmp2);
				}
			}
			System.out.println("#" + t + " " + nums.pop());
		}
		sc.close();
	}

	private static int getPriority(char c) {
		if (c == '*')
			return 2;
		else if (c == '+')
			return 1;
		else
			return -1;
	}
}