package com.day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 상호의 배틀필드
public class SWEA1873 {

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;

	static int H;
	static int W;

	static int N;

	// 전차의 위치 인덱스
	static int px;
	static int py;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/map2.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테스트 케이스

		//////////////////////////////////////

		for (int test_case = 1; test_case <= T; test_case++) {

			H = sc.nextInt(); // Height
			W = sc.nextInt(); // Width

			map = new char[H][W];

			// 입력
			for (int r = 0; r < H; r++) {
				char[] temp = sc.next().toCharArray();
				map[r] = temp;
			}

			N = sc.nextInt(); // 사용자가 넣을 입력의 수

			char[] movements = new char[N];
			char[] temp = sc.next().toCharArray();

			for (int i = 0; i < N; i++) {
				movements[i] = temp[i];
			}

			// 전차 찾기? (전차 인덱스, 전차 방향)
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
						px = i;
						py = j;
					}
				}
			}

			// 동작 순서대로 실행
			for (int i = 0; i < N; i++) {

				if (movements[i] == 'S') {
					shoot(map[px][py]);
				} else if (movements[i] == 'U') {
					turn('U', px, py);
					move('U', px, py);
				} else if (movements[i] == 'D') {
					turn('D', px, py);
					move('D', px, py);
				} else if (movements[i] == 'R') {
					turn('R', px, py);
					move('R', px, py);
				} else if (movements[i] == 'L') {
					turn('L', px, py);
					move('L', px, py);
				}
			}

			System.out.print("#" + test_case + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void turn(char c, int x, int y) {
		switch (c) {
		case 'U':
			map[x][y] = '^';
			break;
		case 'D':
			map[x][y] = 'v';
			break;
		case 'L':
			map[x][y] = '<';
			break;
		case 'R':
			map[x][y] = '>';
			break;
		default:
			break;
		}
		px = x;
		py = y;
	}

	private static void move(char c, int x, int y) {
		switch (c) {
		case 'U':
			if (x - 1 >= 0 && x - 1 < H && map[x - 1][y] == '.') {
				map[x][y] = '.';
				map[x - 1][y] = '^';
				px = x - 1;
			}
			break;
		case 'D':
			if (x + 1 >= 0 && x + 1 < H && map[x + 1][y] == '.') {
				map[x][y] = '.';
				map[x + 1][y] = 'v';
				px = x + 1;
			}
			break;
		case 'L':
			if (y - 1 >= 0 && y - 1 < W && map[x][y - 1] == '.') {
				map[x][y] = '.';
				map[x][y - 1] = '<';
				py = y - 1;
			}
			break;
		case 'R':
			if (y + 1 >= 0 && y + 1 < W && map[x][y + 1] == '.') {
				map[x][y] = '.';
				map[x][y + 1] = '>';
				py = y + 1;
			}
			break;
		default:
			break;
		}
	}

	private static void shoot(char value) {
		int sx = px;
		int sy = py;

		while (true) {
			switch (value) {
			case '^':
				sx += dx[0];
				sy += dy[0];
				break;
			case 'v':
				sx += dx[1];
				sy += dy[1];
				break;
			case '<':
				sx += dx[2];
				sy += dy[2];
				break;
			case '>':
				sx += dx[3];
				sy += dy[3];
				break;
			default:
				break;
			}

			// 밖으로 나가면
			if (sx < 0 || sx >= H || sy < 0 || sy >= W) {
				break;
			} else if (map[sx][sy] == '*') { // 벽돌 만나면
				map[sx][sy] = '.'; // 평지로 바꿈
				break;
			} else if (map[sx][sy] == '#') { // 강철만나면
				// 아무것도 안함
				break;
			} else {
				continue;
			}

		}

	}

}
