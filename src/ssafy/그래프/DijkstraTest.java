package com.day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

==> 8

4 
0 94 53 16 
79 0 24 18 
91 80 0 98 
26 51 92 0
==> 16


7
0   2   8   5   9  15  20
2   0   5   4   7  10  16
8   5   0   7   6   4  10
5   4   7   0  15   8   9
9   7   6  15   0  11  13
15 10   4   8  11   0   6
20 16  10   9  13   6   0

==> 14
 */

// 다익스트라 알고리즘!
public class DijkstraTest {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine().trim());
		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int start = 0; // 시작정점
		int end = V - 1; // 끝정점
		final int INFINITY = Integer.MAX_VALUE; //

		int[][] matrix = new int[V][V]; // 인접행렬
		int[] distance = new int[V]; // 출발지부터 자기자신까지의 최소비용거리 배열
		boolean[] visited = new boolean[V]; // 지금까지 선택된 정점에 대한 true/false 배열

		for (int i = 0; i < V; ++i) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			for (int j = 0; j < V; ++j) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 인접행렬 입력

		Arrays.fill(distance, INFINITY); // 초기화
		distance[start] = 0; // 정점 0에서 0까지의 거리

		int min = 0, current = 0; // 현재 정점 -> 0
		for (int i = 0; i < V; ++i) { // 모든 정점에 대한

			min = INFINITY; // 처음에 최소값을 구하기 위해 무한대 값으로 초기화
			for (int j = 0; j < V; ++j) { // 현재정점에서 모든 정점에 대한
				if (!visited[j] && distance[j] < min) { // 이제까지 선택되지 않은 정점 && 출발지에서의 거리 배열인 distance 배열 값중 최소값 min보다
														// 작으면,
														// 여기서 인접정점이 아니면 무한대값이므로 그 조건도 포함되어있음
					min = distance[j]; // 최소값 갱신
					current = j; // 현재 정점 설정
				}
			}
			visited[current] = true; // 현재정점 방문표시
			if (current == end) { // 현재정점이 끝정점이면
				break; // 끝
			}

			for (int c = 0; c < V; ++c) {
				// 아직 선택되지 않았고 && 인접정점이어야하고 && 시작정점에서의 현재정점까지의 이전 거리 보다 최소값을 구해서 거쳐온 거리가 더 작으면
				if (!visited[c] && matrix[current][c] != 0 && distance[c] > min + matrix[current][c]) { // 프림알고리즘이랑 비슷?
					distance[c] = min + matrix[current][c]; // 다시 갱신!
				}
			}
		}
		System.out.println(distance[end]); // 반복문을 빠져나오면 시작정점에서 끝정점의 최소비용 거리를 출력
	}

}
