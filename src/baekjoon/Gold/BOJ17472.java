package com.day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 다리만들기2 골드2

/* 1.입력받은 섬의 정보를 바탕으로 섬마다 번호를 붙여 줌.(DFS)
 * 2.각 섬에서 출발해서 도착 가능한 다른 섬에 다리를 건설해 봄.(BFS)
 * 3.모든 섬을 연결하는 다리길이의 최소값 찾음.(KRUSKAL:UNION-FIND) 
 * */
public class BOJ17472 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C, N;//N:섬번호
	static int[][] map;
	static int[] parent;//union-find 작업시 필요한 대표자 저장 배열	
	static Queue<Island> q = new LinkedList<>();//섬 정보 저장할 리스트
	static PriorityQueue<Island> pq = new PriorityQueue<>();//다리길이 기준으로 정렬된 섬 정보가 저장이 되는 큐
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		//1.섬인곳 -1로 표시
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());			
			for (int j = 0; j < C; j++) {
				if(Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = -1;//섬번호를 1번부터 사용할거라서 
				}
			}			
		}
		
		//2.섬 넘버링(1~N): DFS
		N = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == -1)
					dfs(i,j,N++);
			}
		}
		
		//for (int i = 0; i < R; i++) {
		//	System.out.println(Arrays.toString(map[i]));
		//}
		
		//3.union-find준비 작업:대표자 배열 만드는 작업
		make();
		
		//4.각 섬(q)들을 잇는 다리 건설->pq에 다리정보 저장
		buildBridge();
		
		//5.각섬들을 최소비용으로 연결해주는 다리 찾기(MST)
		System.out.println(mst());
	}
	
	//섬들 간의 다리 만들어 보기:큐에서 섬정보를 꺼내서 다리 만들어 보기
	private static void buildBridge() {
		while(!q.isEmpty()) {
			Island n = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = n.x + dx[i];
				int ny = n.y + dy[i];
				
				int length = 0;//다리길이
				
				//새로 이동하려는 위치가 배열 안이라면 다리 건설 시도 가능
				while(nx >= 0 && ny >= 0 && nx < R && ny < C ) {
					if(map[nx][ny] != 0) {//섬.자기섬일수도 있고 다른 섬일수도 있음.다리 더이상 못만듦
						//작은번호섬->큰번호섬 방향으로만 다리 건설(1->2, 2->1은 동일하니까)
						if(n.val < map[nx][ny]) {// 1->2, 2->3
							//두 섬을 잇는 다리 하나 완성
							pq.add(new Island(map[n.x][n.y],//시작섬번호
									          map[nx][ny],//도착섬번호
									          length));//길이
						}
						break;//다리건설 끝이니까 이방향으로는 고만
						
					}else {//0. 바다이니까 다리 건설 가능
						length++;
						nx += dx[i];
						ny += dy[i];						
					}					
				}				
			}			
		}		
	}
	
	//각섬을 잇는 다리 중 최소 길이를 갖는 다리들 선택해서 모든 섬 연결
	private static int mst() {
		int sum = 0;
		while(!pq.isEmpty()) {
			Island n = pq.poll();//1->2, 3
			
			//다리길이가 2이상이고 시작섬과 도착섬이 서로 다르다면
			if(n.val >= 2 && union(n.x, n.y)) {
				sum += n.val; //다리 길이 누적
			}			
		}
		
		//모든 섬이 연결됐나요?
		int rootCnt = 0;//-1값 갯수 체크
		for (int i = 0; i < N; i++) {
			if(parent[i] == -1) {//초기값
				rootCnt++;
			}
		}			
		return (rootCnt == 1) ? sum: -1;
	}

	private static void dfs(int x, int y, int no) {
		q.add(new Island(x, y, no));//x,y좌표, 섬번호
		map[x][y] = no;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] == -1) {
				dfs(nx, ny, no);
			}			
		}		
	}
	
	private static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) {
			parent[b] = a;
			return true;
		}
		return false;
	}

	private static int find(int a) {
		if (parent[a] < 0) {//자기가 대표
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void make() {
		parent = new int[N];//대표자 배열		
		for (int i = 1; i < N; i++) {
			parent[i] = -1;
		}		
	}
	
	static class Island implements Comparable<Island>{
		int x, y, val;//섬번호

		public Island(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(Island o) {			
			return this.val - o.val;
		}	
	}
//	static String src = "7 8\r\n" + 
//			"0 0 0 0 0 0 1 1\r\n" + 
//			"1 1 0 0 0 0 1 1\r\n" + 
//			"1 1 0 0 0 0 0 0\r\n" + 
//			"1 1 0 0 0 1 1 0\r\n" + 
//			"0 0 0 0 0 1 1 0\r\n" + 
//			"0 0 0 0 0 0 0 0\r\n" + 
//			"1 1 1 1 1 1 1 1";

}
