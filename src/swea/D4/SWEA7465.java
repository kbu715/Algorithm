package com.day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 창용 마을 무리의 개수 D4
public class SWEA7465 {

	static int answer = 0;
	static int N; // N명 마을 사람
	static int M; // M개의 줄에 걸쳐 알고 있는 사람
	static int[] parents; // 부모 원소를 관리 (트리처럼 사용)
	static HashSet<Integer> set;

	private static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (parents[a] == a)
			return a; // 자신이 대표자
		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int aRoot, bRoot;
		aRoot = find(a);
		bRoot = find(b);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			set = new HashSet<Integer>();
			M = Integer.parseInt(st.nextToken());

			make();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				union(a, b); // 한번 합치고 난뒤
				// 한번씩 대표자 체크해서 바꿔준다.
				for (int j = 1; j <= N; j++) {
					find(j);
				}
				System.out.println(Arrays.toString(parents));
			}

			for (int i = 0; i < parents.length; i++) {
				set.add(parents[i]);
			}

			answer = set.size() - 1;

			System.out.println("#" + tc + " " + answer);
		}
	}

}
