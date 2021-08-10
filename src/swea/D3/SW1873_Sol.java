package com.day3.cls;
import java.util.Scanner;

//1. 맵을 입력받고 전차의 위치찾기.
//2. 명령을 입력받고, 명령을 구분하기.
//3. 명령에 따른 동작 구현하기.
//  현재 전차좌표에서 이동하는 방향으로 좌표 이동.(새로운 변수에 좌표가 저장되겠지)
//  그 좌표가 밖으로 나갔는지 검사. 그러면 return;
//  안나갔으면. 그 좌표가 평지인지 검사.
//  평지이면 해당 자리에 전차놓고 전차있던 자리에 평지로 만들고
//4. 대포발사 구현하기.
//  현재 전차의 모양을 보고 방향을 정함
//  해당 방향으로 한칸씩 이동하기를 반복
//      밖으로 나가면 끝
//      벽을 만나면 평지로 바꾸고 끝
//      철벽을 만나면 그냥 끝
public class SW1873_BattleField2 {
	//상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			// 높이와 너비를 입력받음.
			int H = sc.nextInt();
			int W = sc.nextInt();		
			char[][] map = new char[H][W];
			
			// 전차의 위치
			int tx = 0, ty = 0;
			
			// 맵을 입력받고, 입력에서 전차가 발견되면 전차의 위치를 기억.
			for (int i = 0; i < H; i++) {				
				map[i] = sc.next().toCharArray();//한행 입력
				
				for (int j = 0; j < map[i].length; j++) {//입력 받은 행에 전차가 있는지 조사
					switch (map[i][j]) {//현재 위치에
						case '<':
						case '>':
						case '^':
						case 'v':
							
							tx = i;
							ty = j;
							break;
					}
				}
			}

			//명령을 입력받음.
			int N = sc.nextInt();//명령의 갯수.23			
			String command = sc.next();//명령. SURSSSSUSLSRSSSURRDSRDS
			
			//명령 한개씩 수행
			for (int i = 0; i < command.length(); i++) {
				//명령을 구분하기.
				char c = command.charAt(i);
				
				switch (c) {
					case 'U'://위로 이동해야 함
						map[tx][ty] = '^';//탱크의 방향을 위로 보도록 수정
						move(map, tx, ty, 0);//위로 이동
						break;
					case 'D':
						map[tx][ty] = 'v';//
						move(map, tx, ty, 1);
						break;
					case 'L':
						map[tx][ty] = '<';
						move(map, tx, ty, 2);
						break;
					case 'R':
						map[tx][ty] = '>';
						move(map, tx, ty, 3);
						break;
					case 'S':
						shoot(map, tx, ty);
						break;
				}
			}
			
			//결과 출력. 배열안의 내용 출력
			System.out.print("#" + tc + " ");
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++)
					System.out.print(map[i][j]);
				System.out.println();
			}

		}
	}

	static void shoot(char[][] map, int tx, int ty) {
		int dir = 0;
		//현재 전차의 모양을 보고 방향을 결정
		switch (map[tx][ty]) {
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		}
		//nx ny는 대포알이 날아가는 위치. 현재 전차의 위치에서 시작.
		int nx = tx;
		int ny = ty;
		
		while (true) {
			//방향으로 계속 이동.
			nx = nx + dx[dir];
			ny = ny + dy[dir];
			//밖으로 나가면 끝
			if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
				return;
			//벽을 만나면 부심(평지로 바꿈) 그리고 끝
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			//강벽을 만나면 그냥 끝
			} else if (map[nx][ny] == '#')
				return;
		}

	}

	static void move(char[][] map, int tx, int ty, int dir) {
		// U:0, D:1, L:2, R:3

		//해당 방향으로 이동.
		int nx = tx + dx[dir];
		int ny = ty + dy[dir];
		
		//밖으로 나가는 거면 무효.
		if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length)
			return;
		
		//이동하는 위치가 평지여야 이동가능
		if (map[nx][ny] == '.') {
			//새로 이동하는 자리에 현재 전차를 갖다 놓고
			map[nx][ny] = map[tx][ty];
			
			//원래있던 자리를 평지로 바꿈.
			map[tx][ty] = '.';
			
			//전차의 위치 갱신
			tx = nx;
			ty = ny;
		}
	}
}