package com.day10;

import java.util.ArrayList;
import java.util.Scanner;

// 치킨 배달 골드V
public class BOJ15686_Sol {
	static int N, M;
	static ArrayList<Point> homes; // 집
	static ArrayList<Point> chickens; // 치킨집
	static Point[] selected; // 선택된 치킨집 M개
	static int minDistance; // 답: 도시의 치킨거리 중 최소값

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 배열차수
		M = sc.nextInt(); // 살아남을 치킨집 수

		homes = new ArrayList<>();
		chickens = new ArrayList<>();
		selected = new Point[M]; // 전체 치킨집 중에서 M개 골라서 저장

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int val = sc.nextInt();
				if (val == 1)
					homes.add(new Point(i, j));
				else if (val == 2)
					chickens.add(new Point(i, j));
			}
		} // input

		minDistance = Integer.MAX_VALUE;
		comb(0, 0);// count, start
		System.out.println(minDistance);

		sc.close();
	}

	private static void comb(int count, int start) {
		if (count == M) { // 조합 하나 완성
			checkDistance(); // 그 조합으로 '도시 치킨거리' 계산함
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			selected[count] = chickens.get(i);
			comb(count + 1, i + 1);
		}
	}

	// 완성된 하나의 치킨집 조합을 사용해서 도시의 치킨거리 계산.
	// 계산된 결과를 minDistance 에 저장을 해줌
	private static void checkDistance() {

		int sum = 0; // 모든 집들의 치킨거리 합 -> 도시의 치킨거리
		for (Point home : homes) {
			int min = Integer.MAX_VALUE; // 한집의 치킨거리

			for (Point chicken : chickens) {
				int dist = Math.abs(chicken.x - home.x) + Math.abs(chicken.y - home.y);
				min = Math.min(min, dist);
			}
			// 여기까지 오면 한집의 치킨거리 결정됐음
			sum += min; // 도시의 치킨거리에 누적
			if (sum > minDistance) {
				return; //최적화
			}
		}
		// 모든 집의 치킨거리의 합이 계산됨 -> 도시의 치킨거리
		minDistance = Math.min(minDistance, sum);
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
