package com.day3;

import java.util.Scanner;

public class FloydTest { // 다익스트라 알고리즘 보다 간단한 // 모든정점에대한 모든정점으로의 최단거리 알고리즘

//	4
//	0 2 0 15
//	0 0 10 4
//	3 0 0 0
//	0 0 7 0
	
	static int INF = 99999;
	static int N, dist[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dist = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] =sc.nextInt();			
				// 자기자신으로의 인접 정보가 아니고 인접해 있지 않다면
				if(i != j && dist[i][j] == 0) {
					dist[i][j] = INF;
				}
			}
		}// 입력
		System.out.println("초기 상태 : ");
		print();
		
		// 경유지 -> 출발지 -> 도착지 (경출도)
		for (int k = 0; k < N; k++) { // 경유지
			for (int i = 0; i < N; i++) { // 출발지
				if(k == i) continue;
				for (int j = 0; j < N; j++) { // 도착지
					if(i==j || k == j) continue;
					
					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j]; // 갱신
					}
				}
			}
			System.out.println("경유지 : " + (k+1) + "번까지 고려한 경우");
			print();
		}
		
		System.out.println(dist[2][0]); // 3번 정점에서 1번 정점 예를들면
	}
	
	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(dist[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("----------------------------");
	}

}
