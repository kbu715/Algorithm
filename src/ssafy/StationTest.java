// Intermediate 예제풀이 - 기지국
// 보충수업 문제

package com.ssafy.afterclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StationTest {

	public static void main(String[] args) throws FileNotFoundException {

		System.setIn(new FileInputStream("res/station-data.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // test case 수

		// 하나의 기준점에서 상하좌우 접근 시 좌표값의 변화량
		int[] dx = { -1, 1, 0, 0 }; // 상하좌우 행 값 (x값)
		int[] dy = { 0, 0, -1, 1 }; // 상하좌우 열 값 (y값)

		for (int tc = 1; tc <= T; tc++) {

			int answer = 0; // 답

			int N = sc.nextInt(); // 배열 차수

			char[][] map = new char[N][N];

			// 1. map에 입력 받기 -> 확인

			for (int i = 0; i < N; i++) {
				String line = sc.next(); // 한줄 XXXXXXXXX
				map[i] = line.toCharArray(); // 'X', 'X', 'X', ...
			}

//			System.out.println(Arrays.deepToString(map)); // 확인함.

			// 2. 기지국 종류별로 커버하는 영역 확인

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] >= 'A' && map[i][j] <= 'C') { // 기지국인 경우에만 // A or B or C
						int cnt = map[i][j] - 'A' + 1; // 코드값으로 계산 -> 정수로 바뀜 // 커버할 칸의 수 // A는 1칸, B는 2칸, C는 3칸

						for (int k = 1; k <= cnt; k++) { // 커버할 칸의 갯수 만큼

							// 4방 커버 표시
							for (int m = 0; m < 4; m++) {
								int nx = i + dx[m] * k;
								int ny = j + dy[m] * k;

								// 경계 안쪽에 들어있고 그 곳이 Home인지 확인
								if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 'H') {
									map[nx][ny] = 'X';
								}
							}
						}
					}
				}
			}

			// 3. 커버 안된 남은 집 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H') {
						answer++;
					}
				}
			}
			// 4. 결과 출력
			System.out.println("#" + tc + " " + answer);

		}
	}
}
