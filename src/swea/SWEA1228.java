package com.day6;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class SWEA1228 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/pw.txt"));
		Scanner sc = new Scanner(System.in);

		LinkedList<Command> inst; // 명령어를 담을 리스트
		LinkedList<String> origin; // 원본 암호문

		for (int test_case = 1; test_case <= 10; test_case++) {
			inst = new LinkedList<>(); 
			origin = new LinkedList<>(); 
			int N = sc.nextInt(); // 원본 암호문의 길이 N
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				origin.add(temp);
			}

			int I = sc.nextInt(); // 명령어의 개수
			int index;
			int num;
			String[] numbers;
			// 큐 삽입
			for (int j = 0; j < I; j++) {
				if (sc.next().equals("I")) { // "I" 명령어를 만나면
					index = sc.nextInt();
					num = sc.nextInt();
					numbers = new String[num];
					for (int k = 0; k < num; k++) {
						numbers[k] = sc.next();
					}
					inst.offer(new Command(index, num, numbers));
				}
			}

			while (!inst.isEmpty()) {
				Command c = inst.poll();
				int start = c.index;
				int end = c.index + c.num;
				int cnt = 0;
				for (int j = start; j < end; j++) {
					origin.add(j, c.numbers[cnt++]);
				}
			}

			System.out.print("#" + test_case + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(origin.poll() + " ");
			}
			System.out.println();
			inst.clear();
			origin.clear();
		}
	}

	static class Command {
		int index; // x의 위치
		int num; // y개의 숫자
		String[] numbers; // 숫자들 배열

		public Command(int index, int num, String[] numbers) {
			this.index = index;
			this.num = num;
			this.numbers = numbers;
		}
	}

}
