import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5643_DFS_2 {

	static int N, M, adj[][], radj[][]; // reversed
	static int cnt;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {

			N = Integer.parseInt(br.readLine()); // 학생수
			M = Integer.parseInt(br.readLine()); // 간선정보수
			adj = new int[N + 1][N + 1];
			radj = new int[N + 1][N + 1]; // 역인접행렬

			StringTokenizer st = null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				radj[to][from] = adj[from][to] = 1; // from 보다 to가 키가 크다.

			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				cnt = 0;
				dfs(i, adj, new boolean[N + 1]); // 자신보다 큰 학생 탐색
				dfs(i, radj, new boolean[N + 1]); // 자신보다 작은 학생 탐색

				if (cnt == N - 1)
					++answer;

			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	// 자신보다 큰 학생따라 탐색
	private static void dfs(int cur, int[][] adj, boolean[] visited) {

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				++cnt;
				dfs(i, adj, visited);
			}
		}

	}

}
