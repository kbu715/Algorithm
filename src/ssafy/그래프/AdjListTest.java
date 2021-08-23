package com.day15;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접 행렬 
public class AdjListTest { // 무향 그래프

	static class Node {
		int vertex; // 인접정점 인덱스
		Node link;

		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}

	static int N; // 정점 개수
	static Node[] adjList; // 인접리스트 (가중치없음) / 헤드의 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/graph_input.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjList = new Node[N];

		int C = Integer.parseInt(in.readLine()); // 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]); // 무향 그래프여서
			adjList[to] = new Node(from, adjList[to]);
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

			for (Node temp = adjList[current]; temp != null; temp = temp.link) { // 인접리스트 반복문! null일때까지 반복
				// 미방문 && 인접정점
				if (!visited[temp.vertex]) {
					queue.offer(temp.vertex); // 큐에 넣고 순서를 기다림
					visited[temp.vertex] = true; // 방문처리
				}
			}
		}
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;
		System.out.println((char) (current + 65)); // 알파벳으로 출력하기위한

		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			// 미방문 && 인접정점
			if (!visited[temp.vertex]) {
				dfs(temp.vertex, visited);
			}
		}

	}

}
