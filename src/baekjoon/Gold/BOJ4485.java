import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 골드 4 녹색 옷 입은 애가 젤다지?
public class BOJ4485 {
	static int N;
	static int[][] map;
	static int[][] cost;
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0) {
				break;
			}

			map = new int[N][N];
			cost = new int[N][N]; // 해당 좌표까지 오는데 든 최소 비용을 저장

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++)
					cost[i][j] = Integer.MAX_VALUE; // 최대값으로 초기화
			}

			cost[0][0] = map[0][0]; // 출발지점 비용 초기화

			bfs(0, 0);

			System.out.println("Problem " + tc + ": " + answer);
			tc++;
		}
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if (cost[nx][ny] > cost[cur[0]][cur[1]] + map[nx][ny]) {
					cost[nx][ny] = cost[cur[0]][cur[1]] + map[nx][ny]; // 최소 비용 갱신
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		answer = cost[N - 1][N - 1];
	}
}