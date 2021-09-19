package com.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


// 맥주마시면서 걸어가기 실버1
public class BOJ9205_SOL {
	
	static int N; //편의점 갯수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		ArrayList<Point> list; //// 좌표값(집, 편의점, 페스티벌) 저장할 리스트
		boolean[][] isConnected; // 정점간의 연결 여부를 나타내 주는 배열
		StringBuffer sb = new StringBuffer();
		
		for (int tc = 1; tc <= T; tc++) {
				
			N = Integer.parseInt(br.readLine()); // 편의점 갯수
			list = new ArrayList<>(); // 집, 편의점, 페스티벌 좌표 리스트
			
			for (int i = 0; i < N+2; i++) {
				
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				list.add(new Point(x,y));
			}
			
			// 각 정점별 연결 여부 체크
			isConnected = new boolean[N+2][N+2];
			
			// 하나의 정점에서 다른 정점들 과의 연결 여부 체크
			// 두 정점간의 거리(맨해튼거리)가 1000m 이하라면 연결 가능 -> true라고 표시
			for (int i = 0; i < N+1; i++) {
				for (int j = 0; j < N+2; j++) {
					if(i!=j && getDistance(list.get(i), list.get(j)) <= 1000) {
						isConnected[i][j] = isConnected[j][i] = true;
					}
				}
			}
			
//			System.out.println(Arrays.deepToString(isConnected));
			
			// 출발지 ~ 경유지 ~ 도착지 까지 연결되어 있나요?
			floyd(isConnected); // 각 정점간의 연결정보가 들어있는 배열 전달
//			System.out.println(Arrays.deepToString(isConnected));			
			
			
			sb.append((isConnected[0][N+1] ? "happy" : "sad") + "\n");
			
		}
		System.out.println(sb);
	}
	
	// 출 ~ 경 ~ 목
	private static void floyd(boolean[][] isConnected) {
		
		for (int via = 0; via < N+2; via++) {
			for (int from = 0; from < N+2; from++) {
				if(via == from) continue;
				for (int to = 0; to < N+2; to++) {
					if(from == to || via == to) continue;
					
					// from-to가 연결되어 있나요?
					
					if(isConnected[from][via] && isConnected[via][to]) {
						isConnected[from][to] = true;
					}
				}
				
			}
			
		}
		
	}
	private static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}

}

class Point { // 좌표
	int x,y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
