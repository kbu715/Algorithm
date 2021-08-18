package com.day12;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ17135_Sol {

	static int N, M, D;// 행, 열, 공격 거리제한
	static int max;// 답 . 제거할 수 있는 적의 최대수
	static int[] selected;// 궁수 위치 조합(열값). 3칸
	static ArrayList<Enemy> elist;// 적군 정보 저장 리스트

	static class Enemy {// inner class
		int x, y;

		public Enemy(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1.초기값 받기
		N = sc.nextInt();// 행
		M = sc.nextInt();// 열
		D = sc.nextInt();// 거리제한
		selected = new int[3];

		// 2.적군정보 저장
		elist = new ArrayList<>();// 적군 저장 리스트
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (sc.nextInt() == 1) {// 적!
					elist.add(new Enemy(i, j));
				}
			}
		}

		// 3.궁수 위치 조합을 만들어서 각 조합마다 몇명을 죽일 수 있는 지 계산->max값 계산
		combination(0, 0);

		// 4. 결과 출력
		System.out.println(max);
	}

	// 궁수의 위치 조합 생성
	private static void combination(int cnt, int start) {
		if (cnt == 3) {// 조합 완성. 쏘러 가야 됨. 0,1,2

			// 조합이 완성 될 때마다 적을 죽여봐야 하니까 원본은 그대로 두고
			// 복사본을 만들어서 사용해야 함(다른 조합에서도 사용해야 하니까)
			ArrayList<Enemy> copy = new ArrayList<>();// cpoy
			for (Enemy e : elist) {
				copy.add(new Enemy(e.x, e.y));// deep copy
			}

			int killed = gameStart(copy, selected);// 하나의 궁수 조합 당 사살된 적의 수
			max = Math.max(killed, max);
			return;
		}

		for (int i = start; i < M; i++) {
			selected[cnt] = i;
			combination(cnt + 1, i + 1);
		}

	}

	// 하나의 궁수 조합으로 죽일 수 있는 적의 수를 계산해서 그 값을 리턴
	// archers: 궁수들의 y좌표. x좌표는 N
	private static int gameStart(ArrayList<Enemy> clist, int[] archers) {
		int count = 0;// 죽인 적의 수

		while (clist.size() != 0) {
			// 1.죽일 적을 정하기-죽을 후보들
			ArrayList<Enemy> tmp = new ArrayList<>();

			// 2. 궁수 3명이 한번씩 쏴봄
			for (int a : archers) {
				// clist에서 a와 제일 가까운 적을 찾아 그 적의 인덱스를 리턴해 줌
				int targetIndex = findNear(clist, a);

				if (targetIndex >= 0) {// 적을 발견한 경우
					tmp.add(clist.get(targetIndex));
				}
			}
			// tmp에 죽을 후보가 저장되어 있음

			// 3.tmp에서 한놈씩 꺼내서 정말로 삭제
			for (Enemy e : tmp) {
				if (clist.remove(e))
					count++;
			}
			// 4.적군 하강
			enemyDown(clist);
		}
		return count;
	}

	private static void enemyDown(ArrayList<Enemy> clist) {
		for (int i = 0; i < clist.size(); i++) {
			Enemy e = clist.get(i);
			e.x++;// 아래로 내려오니까

			if (e.x == N) {// 성벽에 닿음
				clist.remove(i);// 죽음
				i--;// remove해서 뒤에 있던 애가 앞칸으로 오니까
			}
		}
	}

	// 궁수 한명의 위치에서 가장 가까운 적의 인덱스 리턴
	private static int findNear(ArrayList<Enemy> clist, int a) {
		int minDist = Integer.MAX_VALUE;// 적과의 가장 가까운 거리
		int minColumn = 20;// 가장 가까운 적의 컬럼 값(y).같은 거리의 적이 발견 되면 더 왼쪽적이 우선임.
		int index = -1;// clist안에서의 가장 가까운 적의 인덱스

		for (int i = 0; i < clist.size(); i++) {
			Enemy e = clist.get(i);

			// 궁수와 적 한사람과의 거리 계산
			int distance = N - e.x + Math.abs(a - e.y);
			if (distance > D)
				continue;

			// 기존 최단거리보다 지금 계산한 거리가 더 짧으면
			if (distance < minDist) {
				minDist = distance;
				minColumn = e.y;// 적의 열값. 나중에 같은 거리가 나오게 되면 더 왼쪽에 있는 애를 찾아야 됨.
				index = i;

			} else if (distance == minDist) {// 더 왼쪽에 있는 애를 찾아야 됨.
				if (e.y < minColumn) {// e.y가 더 왼쪽
					minColumn = e.y;
					index = i;
				}
			}
		}

		return index;
	}
}