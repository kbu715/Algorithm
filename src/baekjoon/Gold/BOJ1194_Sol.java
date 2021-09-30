import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs, visit[k][x][y]
public class BOJ1194_Sol {
	static class Position {
		int x, y, k;// k:민식이의 열쇠보유상태

		public Position(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	static Queue<Position> q;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][][] visit;// [k][x][y]
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());// 세로
		M = Integer.parseInt(st.nextToken());// 가로

		q = new LinkedList<>();
		map = new char[N][M];
		visit = new boolean[64][N][M];// 0(000000)~63(111111)까지 64개의 열쇠보유상태가 존재

		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];

				if (map[i][j] == '0') {// 민식이 발견!
					q.offer(new Position(i, j, 0));// 열쇠없어
					visit[0][i][j] = true;
					map[i][j] = '.';
				}
			}
		} // 입력완료

		System.out.println(bfs());
	}

	private static int bfs() {
		int move = 0;// 움직인 횟수 저장할 변수

		while (!q.isEmpty()) {
			int size = q.size();// 현재 큐에 들어있는 Position들의 갯수
			move++;

			// 현재 큐에 들어있던 위치값들 만으로 4방 탐색을 하겠다!!!
			for (int i = 0; i < size; i++) {//
				Position p = q.poll();
				int x = p.x;
				int y = p.y;
				int k = p.k;// 0

				for (int j = 0; j < 4; j++) {// 꺼낸애에 대해 4방탐색
					int nx = x + dx[j];
					int ny = y + dy[j];
					int nk = k;// 000000

					if (nx < 0 || ny < 0 || nx >= N || ny >= M)
						continue;

					if (map[nx][ny] == '#' || visit[k][nx][ny] == true)
						continue;

					if (map[nx][ny] == '1')// 출구
						return move;

					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {// 열쇠 만났을때 ->주워야 됨
						// 문자인 열쇠를 숫자로 변환시켜줌. a->0, b->1, c->2...
						int shift = (map[nx][ny] - 'a');// 쉬프트 연산시 이동시킬 횟수
						// 1 << ?
						int key = 1 << shift;// a -> 000001, b ->000010...

						// 열쇠가 없다면 |연산으로 열쇠를 주움.
						// if((k & key) != key) {//그 열쇠 없어
						if ((k & key) == 0) {// 그 열쇠 없어
							nk = k | key;// 열쇠 get
						}
					} else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {// 문을 만났을때
						int door = 1 << (map[nx][ny] - 'A');
						if ((k & door) == 0) {// 그 열쇠 없어
							continue;// 다른 방향으로 가야돼
						}
					}

					// 빈공백을 만난 경우, 열쇠를 만나고 나서, 열쇠가 있어서 문을 열고 통과한 경우
					q.offer(new Position(nx, ny, nk));// 다음번에 nk의 열쇠상태로 nx, ny위치에서부터 탐색 시작!!!
					visit[k][nx][ny] = true;// 열쇠가 k인 상태에서 nx, ny위치를 가봤어요!라는 의미
				}
			}
		}

		return -1;
	}

}