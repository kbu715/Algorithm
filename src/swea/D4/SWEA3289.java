package com.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 서로소 집합 D4
public class SWEA3289 {
	static int N; // 원소 개수
	static int M; // 연산의 개수
	static int[] parents; // 부모 원소를 관리 (트리처럼 사용)

	// 1.makeset
	private static void makeSet() {
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자
		return parents[a] = find(parents[a]); // 나의 대표자의 대표자를 찾아서 나의 대표자 값으로 지정 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침)
	private static void union(int a, int b) {
		if (!isGroup(a, b)) {
			int aRoot = find(a);
			int bRoot = find(b);
			parents[bRoot] = aRoot;
		}

	}

	private static boolean isGroup(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return true;
		else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parents = new int[N + 1];
			makeSet();

			StringBuilder answer = new StringBuilder();
			answer.append("#" + tc + " ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int func = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				;

				if (func == 0) {
					union(a, b);
				} else {
					if (isGroup(a, b)) {
						answer.append(1);
					} else {
						answer.append(0);
					}
				}
			}
			System.out.println(answer);
		}

	}

}
