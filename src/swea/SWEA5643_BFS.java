import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA5643_BFS {

	static int N, M, adj[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			N = Integer.parseInt(br.readLine()); // 학생수
			M = Integer.parseInt(br.readLine()); // 간선정보수
			adj = new int[N + 1][N + 1];

			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1; // from 보다 to가 키가 크다.
			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (gtBFS(i) + ltBFS(i) == N - 1)
					answer++;
			}
			
			System.out.println("#"+tc+" "+answer);
		}

	}

	// 자신보다 큰 학생따라 탐색
	private static int gtBFS(int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[cur][i] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}

		return cnt;

	}

	// 자신보다 작은 학생따라 탐색
	private static int ltBFS(int start) {

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N + 1];

		queue.offer(start);
		visited[start] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int cur = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[i][cur] == 1) {
					queue.offer(i);
					visited[i] = true;
					++cnt;
				}
			}
		}

		return cnt;

	}

}
