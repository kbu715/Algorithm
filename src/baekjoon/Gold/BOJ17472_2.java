package com.day4;

import java.util.*;

public class BOJ17472_2 {
    static int N, M, islandCnt, answer, answerCnt;
    static int[][] map, dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] parent;
    static PriorityQueue<Node> q;
    static int INF = 100000;

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        answer = 0;
        answerCnt = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        initMap();
        makeBridge();
        kruskal();
        if (answerCnt != islandCnt) {
            System.out.print("-1");
            return;
        }

        System.out.println(answer);
    }

    public static void makeBridge() {
        dist = new int[islandCnt + 1][islandCnt + 1];
        for (int i = 0; i <= islandCnt; i++) {
            for (int j = 0; j <= islandCnt; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    for (int k = 0; k < 4; k++) {
                        int length = 0;
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        while (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                            if (map[nextX][nextY] != 0) {
                                if (length > 1) {
                                    dist[map[i][j] - 1][map[nextX][nextY] - 1] = Math.min(length, dist[map[i][j] - 1][map[nextX][nextY] - 1]);
                                }
                                break;
                            }
                            length++;
                            nextX += dx[k];
                            nextY += dy[k];
                        }
                    }
                }
            }
        }
    }

    public static void kruskal() {
        parent = new int[islandCnt + 1];
        q = new PriorityQueue<>();

        for (int i = 1; i < dist.length; i++) {
            for (int j = 1; j < dist[i].length; j++) {
                if (dist[i][j] != INF) {
                    q.add(new Node(i, j, dist[i][j]));
                }
            }
        }

        for (int i = 0; i <= islandCnt; i++) {
            parent[i] = i;
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (find(node.from) != find(node.to)) {
                union(node.from, node.to);
                answer += node.cost;
                answerCnt++;
            }
        }
    }

    public static int find(int v) {
        if(parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    public static void union(int from, int to) {
        int rootFrom = find(from);
        int rootTo = find(to);
        parent[rootTo] = rootFrom;
    }

    public static void initMap() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        int islandNum = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    islandNum++;
                }

                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    map[cur[0]][cur[1]] = islandNum;
                    for (int k = 0; k < 4; k++) {
                        int nextX = cur[0] + dx[k];
                        int nextY = cur[1] + dy[k];
                        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == 1) {
                            q.add(new int[]{nextX, nextY});
                            visit[nextX][nextY] = true;
                        }
                    }
                }
            }
        }

        islandCnt = islandNum - 1;
    }
}
