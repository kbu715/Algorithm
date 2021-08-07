package com.day2;

import java.io.FileInputStream;
import java.util.Scanner;

// 사다리 타기

public class SWEA1210 {

	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("res/input2.txt"));

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			sc.nextLine();

			String[][] map = new String[100][100]; // 100x100

			// 입력
			for (int i = 0; i < 100; i++) {
				map[i] = sc.nextLine().split(" ");
			}

			int dest = 0; // 도착 인덱스

			for (int j = 0; j < 100; j++) {
				if (map[99][j].equals("2")) {
					dest = j;
					break;
				}
			}

			// index
			int r = 99; // row
			int c = dest; // column

			while (r > 0) {
				// 1. 오른쪽으로 이동
				if (c + 1 < 100 && map[r][c + 1].equals("1")) {
					do {
						c++;
					} while (c + 1 < 100 && map[r][c + 1].equals("1"));
				}
				// 2. 왼쪽으로 이동
				else if (c - 1 >= 0 && map[r][c - 1].equals("1")) {
					do {
						c--;
					} while (c - 1 >= 0 && map[r][c - 1].equals("1"));
				}
				// 3. 좌우가 없으면
				r--;
			}

			System.out.println("#" + tc + " " + c);

		}
	}

}
