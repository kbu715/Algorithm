package com.day16;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 정점크기에 비해서 간선이 많다면 크루스칼 보다는 프림으로 해결하자 
 * 왜? 크루스칼은 정렬을 해야하기 때문에
 */

public class MSTKruskalTest {

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// return this.weight - o.weight
			return Integer.compare(weight, o.weight); // 오름차순
		}
	}

	static int[] parents; // 부모 원소를 관리 (트리처럼 사용)
	static int V, E;
	static Edge[] edgeList;

	private static void make() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; // 이미 같은 집합으로 합치지 않음

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/kruskal_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 간선 리스트 작성
		edgeList = new Edge[E];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(start, end, weight);
		}

		Arrays.sort(edgeList); // 오름차순 정렬

		make(); // 모든 정점을 각각으로 집합으로 만들고 출발

		// 간선 하나씩 시도하며 트리 만들어 감.
		int cnt = 0, result = 0;
		for (Edge e : edgeList) {
			if (union(e.start, e.end)) {
				result += e.weight;
				if (++cnt == V - 1)
					break; // 신장트리 완성
			}
		}

		System.out.println(result);
	}

}
