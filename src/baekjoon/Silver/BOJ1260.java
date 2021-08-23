package com.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 행렬 //DFS와 BFS
public class BOJ1260 {

	static int N; // 정점 개수
	static int M; // 간선 개수
	static int V; // 시작 정점
	static boolean[][] adjMatrix; // 인접행렬

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N + 1][N + 1]; // 1번인덱스는 1번 vertex 하기 위한 처리

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true;
		}

		boolean[] visited = new boolean[N + 1];
		dfs(V, visited);
		System.out.println();
		bfs(V);
	}

	private static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(v);
		visited[v] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			System.out.print(current + " ");

			for (int i = 1; i <= N; i++) {
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
		System.out.print(current + " ");

		for (int i = 1; i <= N; i++) {
			// 미방문 && 인접정점
			if (!visited[i] && adjMatrix[current][i]) {
				dfs(i, visited);
			}
		}

	}

}
