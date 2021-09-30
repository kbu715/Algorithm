import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5643_DFS {

	static int N, M, adj[][];
	static int gtCnt, ltCnt;

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
				gtCnt = ltCnt = 0;
				gtDFS(i, new boolean[N + 1]);
				ltDFS(i, new boolean[N + 1]);
				if (ltCnt + gtCnt == N - 1) // 자신보다 작은 학생수 + 자신보다 큰 학생수 = N-1이면
					answer++; // 자신이 몇번째인지 알게됨
			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	// 자신보다 큰 학생따라 탐색
	private static void gtDFS(int cur, boolean[] visited) {

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) {
				++gtCnt;
				gtDFS(i, visited);
			}
		}

	}

	// 자신보다 작은 학생따라 탐색
	private static void ltDFS(int cur, boolean[] visited) {

		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[i][cur] == 1) {
				++gtCnt;
				gtDFS(i, visited);
			}
		}

	}

}
