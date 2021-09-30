import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1249 {
	static int N;
	static int[][] map;
	static int[][] cost;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int answer;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			map = new int[N][N];
			cost = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					cost[i][j] = Integer.MAX_VALUE; // 최대값으로 초기화
			}

			for (int i = 0; i < N; i++) {
				String[] temp = sc.next().split("");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(temp[j]);
				}
			}

			cost[0][0] = map[0][0];
			bfs(0, 0);
			System.out.println("#" + tc + " " + answer);
		}

	}

	private static void bfs(int x, int y) {
		Queue<Pair> queue = new LinkedList<>();

		queue.add(new Pair(x, y));

		while (!queue.isEmpty()) {
			Pair cur = queue.poll();
			int curX = cur.x;
			int curY = cur.y;

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (cost[nx][ny] > cost[curX][curY] + map[nx][ny]) {
						cost[nx][ny] = cost[curX][curY] + map[nx][ny]; // 최소 비용 갱신
						queue.offer(new Pair(nx, ny));
					}
				}
			}
		}

		answer = cost[N - 1][N - 1];
	}

}

class Pair {
	int x;
	int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
