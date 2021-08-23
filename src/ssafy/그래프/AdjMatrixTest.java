package com.day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 행렬 
public class AdjMatrixTest {

	static int N; // 정점 개수
	static boolean[][] adjMatrix; // 인접행렬(가중치없음)

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/graph_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];

		int C = Integer.parseInt(in.readLine()); // 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}

		System.out.println("===============bfs===============");
		bfs();
		System.out.println("===============dfs===============");
		boolean[] visited = new boolean[N];
		dfs(0, visited);
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N];

		queue.offer(0);
		visited[0] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			System.out.println((char) (current + 65)); // 알파벳으로 출력하기위한

			for (int i = 0; i < N; i++) {
				// 미방문 && 인접정점
				if (!visited[i] && adjMatrix[current][i]) { // 방문하지 않았고 현재 정점에서 지금 가리키는 정점으로 갈 수 있는지
					queue.offer(i); // 큐에 넣고 순서를 기다림
					visited[i] = true; // 방문처리
				}
			}
		}
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65)); // 알파벳으로 출력하기위한

		for (int i = 0; i < N; i++) {
			// 미방문 && 인접정점
			if (!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
			}
		}

	}

}
