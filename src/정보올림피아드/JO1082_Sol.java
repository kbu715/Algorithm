import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JO1082_Sol {

	static Queue<Point> fire, hero; // bfs
	// 상하좌우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int R, C;
	static char[][] map;
	static boolean[][] visit;
	static char[][] trace; /// *** 용사와 불이 어케 움직이나 찍어보기
	static int count;
	static boolean running, possible; // running: bfs 탐색계속 여부. possible: 탈출여부

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		visit = new boolean[R][C];
		trace = new char[R][C];

		fire = new LinkedList<>();
		hero = new LinkedList<>();

		// 입력->용사위치, 불의위치 저장

		for (int i = 0; i < R; i++) {
			char[] temp = sc.next().toCharArray();
			map[i] = temp;
			trace[i] = temp;
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*') // 불
					fire.add(new Point(i, j));
				if (map[i][j] == 'S') // 용사
					hero.add(new Point(i, j));
			}
		} // 입력

		// 둘이 bfs 탐색하게 함
		running = true;
		while (running) {
			goFire(); // 불이퍼짐
			goHero(); // 용사가 이동. 도중에 집에 도착하면 끝. running => false, 시간출력

			// 더이상 불이 펴질 공간이 없고 용사가 이동할 공간이 없으면?
			if (fire.size() == 0 && hero.size() == 0)
				running = false;
		}

		// 집에는 못갔는데 bfs 탐색을 마친 경우
		if (!possible)
			System.out.println("impossible");

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(trace[i][j] + "\t");
//			}
//			System.out.println();
//		}

	}

	private static void goHero() {
		count++;
		int size = hero.size(); // 현재 큐에 들어있는 hero의 갯수만큼
		here: for (int i = 0; i < size; i++) {

			Point p = hero.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (!inRange(nx, ny))
					continue;
				if (map[nx][ny] == 'D') { // 집에왔음
					System.out.println(count);
					running = false;
					possible = true;
					break here;
				}

				if (map[nx][ny] == '.' && !visit[nx][ny]) {
					trace[nx][ny] = '★';
					visit[nx][ny] = true;
					hero.add(new Point(nx, ny));
				}
			}

		}
	}

	private static void goFire() {
		int size = fire.size(); // 현재 큐에 들어있는 불 갯수만큼만 퍼져야 됨
		for (int i = 0; i < size; i++) {

			Point p = fire.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (!inRange(nx, ny))
					continue;
				if (map[nx][ny] == '.' && !visit[nx][ny]) {
					map[nx][ny] = '*'; // 불붙음
					trace[nx][ny] = '◎';
					visit[nx][ny] = true;
					fire.add(new Point(nx, ny));
				}
			}

		}

	}

	private static boolean inRange(int nx, int ny) {
		return (nx >= 0 && ny >= 0 && nx < R && ny < C);
	}

	static class Point { // 불과 용사의 위치정보
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

}
