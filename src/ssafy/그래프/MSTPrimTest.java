package com.day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Minimum Spannig Tree Prim Algorithm
// 임의의 정점 (시작점)을 시작으로 최소비용의 간선을 선택하고 -> 최소비용 정점이 결정 됨 -> mst에 포함
public class MSTPrimTest {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/prim_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] adjMatrix = new int[N][N];
		boolean[] visited = new boolean[N]; // 해당 정점의 방문 여부체크. 해당 정점이 mst에 포함되었는지 여부 체크
		int[] minEdge = new int[N]; // 각 정점별 다른 정점과의 연결 간선 비용 중 최소값.
		// 한 정점과 연결된 다른 간선들의 비용 중 최소값

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				// 정점 i -> j로 가는 간선이 존재하고 그 때 가중치가 adjMatrix[i][j]
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}

		int result = 0; // 최소신장트리 비용
		minEdge[0] = 0; // 임의의 시작점 0의 간선비용을 0으로 세팅

		for (int i = 0; i < N; i++) { // 모든 정점 수만큼 반복
			// 1. 신장트리에 포함되지 않은 정점 중 최소간선비용의 정점 찾기
			int minCost = Integer.MAX_VALUE;
			int minVertex = -1; // 최소간선비용의 정점번호

			// 1. 현재 모든 정점 중에서 가장 작은 간선 비용을 갖는 정점을 찾고 그 때의 비용은 얼마인지 찾음
			for (int j = 0; j < N; j++) {
				// !visited[j]: 정점 i가 mst에 포함이 안됐고
				if (!visited[j] && minCost > minEdge[j]) {
					minCost = minEdge[j]; // 최소 간선 비용
					minVertex = j; // 최소 간선 비용을 가지는 정점의 번호
				}
			}

			visited[minVertex] = true; // 신장트리에 포함시킴
			result += minCost; // 간선비용 누적

			// 2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			// 새로 찾은 정점(minVertex)과 연결된 다른 정점들과의 최소 간선 비용을 업데이트
			for (int j = 0; j < N; j++) {

				// adjMatrix[minVertex][j] != 0 : 0이 아니라는 것은 인접해야 한다는 뜻
				if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}

			}
		}

		System.out.println(result);
	}

}
