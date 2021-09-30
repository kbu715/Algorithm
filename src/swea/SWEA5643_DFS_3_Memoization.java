import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA5643_DFS_3_Memoization {

	static int N, M, adj[][];
	static int cnt;

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

			for (int i = 1; i <= N; i++) {
				adj[i][0] = -1; // 모든 정점에 대한 탐색여부 // -1로 초기화

			}

			int answer = 0;
			for (int i = 1; i <= N; i++) {
				if (adj[i][0] == -1)
					dfs(i); // 자신보다 큰 학생 탐색
			}

			for (int i = 1; i <= N; i++) {
				if (adj[i][0] == adj[0][i])
					answer++;
			}

			System.out.println("#" + tc + " " + answer);
		}

	}

	// 자신보다 큰 학생따라 탐색
	private static void dfs(int cur) {

		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1) { // 자신보다 큰 학생이면
				if (adj[i][0] == -1) { // 아직 탐색이 안된 학생만
					dfs(i);
				}

				// 자신보다 큰 학생을 탐색을 완료한 상태(메모가 되어있으면 탐색안하고 바로 내려옴)
				if (adj[i][0] > 0) { // i보다 큰 학생이 존재
					// i의 인접행렬의 상태를 cur에 반영
					for (int j = 1; j <= N; j++) {
						if (adj[i][j] == 1)
							adj[cur][j] = 1; // memoization
					}
				}
			}
		}

		int rcnt = 0;
		int ccnt = 0;
		for (int i = 1; i <= N; i++) {
			rcnt += adj[cur][i];
			ccnt += adj[i][cur];
		}

		adj[cur][0] = rcnt;
		adj[0][cur] = ccnt;

	}

}
