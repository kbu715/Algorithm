package com.day15;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Contact D4
public class SWEA1238 {

	static int[][] map; // 그래프 정보 저장
	static int N, V, answer; //

	public static void main(String[] args) throws Exception {
		int T = 10;
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			V = sc.nextInt();

			map = new int[101][101]; // 최대 인원수는 100명

			for (int i = 1; i <= N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			} // from -> to 로 가는 간선이 존재

			answer = 0;
			bfs(V);
			System.out.println("#" + tc + " " + answer);
		}
	}

	// 큐를 이용
	private static void bfs(int v) {

		int[] visited = new int[101]; // 정점의 갯수만큼 방문 여부 표시
		Queue<Integer> q = new LinkedList<>();

		q.add(v); // 시작정점
		visited[v] = 1; // 방문처리 해놔야 나중에 동일 정점을 중복 방문 안함 // 방문 순서도 됨
		int current = 0;
		while (!q.isEmpty()) {
			current = q.poll(); // q에서 한개 꺼내고

			// 꺼낸애랑 연결되어 있는 모든 정점을 찾아 q에 저장
			for (int i = 1; i <= 100; i++) {
				// cur -> i정점으로 연결이 되어 있고 i는 아직 방문 안한 값
				if (map[current][i] == 1 && visited[i] == 0) {
					q.add(i);
					visited[i] = visited[current] + 1; // 현재 방문한 값보다 바로 다음 방문 순서를 갖게됨
				}
			} // current과 연결된 모든 정점을 체크한 후
		}
		// 모든 정점에 대한 방문을 마친 후--> last?
		int last = visited[current]; // 중복 방문 방지 역할도 하지만 // 방문 순서도 나타냄

		for (int i = 1; i <= 100; i++) {
			if (last == visited[i]) {
				answer = Math.max(answer, i);
			}
		}
	}

}
