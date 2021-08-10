package com.day4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// 암호생성기
public class SWEA1225 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/queue.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> q = new LinkedList<String>();

		for (int test_case = 1; test_case <= 10; test_case++) {
			br.readLine();
			String[] str = br.readLine().split(" ");

			for (int i = 0; i < str.length; i++) {
				q.offer(str[i]);
			}
			
			top: while (true) {
				for (int i = 1; i <= 5; i++) {
					int front = Integer.parseInt(q.peek());
					int rear = front - i;
					if (rear <= 0) { // 0보다 작거나 같을때 끝낸다
						q.poll();
						q.offer(Integer.toString(0));
						break top;
					}
					q.poll();
					q.offer(Integer.toString(rear));
				}
			}

			System.out.print("#" + test_case + " ");

			while (!q.isEmpty()) { // queue 출력
				System.out.print(q.peek() + " ");
				q.poll();
			}

			System.out.println();
			q.clear();
		}
	}

}
