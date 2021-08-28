package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 한 줄로 서기 실버2
public class BOJ1138 {

	static int N;
	static int[] info;
	static ArrayList<Integer> list; // 정렬 리스트
	static int[] input;
	static int[] selected;
	static boolean[] flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		info = new int[N]; // 자기 왼쪽에 몇명이나 있는지에 대한 정보

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {

			info[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList<Integer>();
		selected = new int[N - 1];
		input = new int[N - 1];
		flag = new boolean[N - 1];

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (info[i] == 0) { // 맨처음 요소는 정해짐
				list.add(0, i + 1);
			} else {
				input[cnt++] = i + 1; // 나머지는 순열 돌리기 위해 input에 담아놓는다.
			}
		}
		perm(0); // 순열

		// 출력
		for (int i = 0; i < N; i++) {
			if (i == N - 1) {
				System.out.print(list.get(i));
			} else {
				System.out.print(list.get(i) + " ");
			}
		}
		list.clear();

	}

	private static boolean check(int[] selected) {
		for (int i = 0; i < selected.length; i++) {
			int countOfLeftPeople = info[selected[i] - 1];

			int cnt = 1; // 처음 요소 포함

			for (int j = 0; j < i; j++) {
				if (selected[i] < selected[j]) {
					cnt++;
				}
			}
			if (countOfLeftPeople != cnt) {
				return false;
			}
		}
		return true;
	}

	private static void perm(int cnt) {
		if (cnt == N - 1) {
			if (check(selected)) {
				for (int i = 0; i < selected.length; i++) {
					list.add(selected[i]);
				}
			}
			return;
		}

		for (int i = 0; i < N - 1; i++) {
			if (flag[i]) {
				continue;
			}
			flag[i] = true;
			selected[cnt] = input[i];
			perm(cnt + 1);
			flag[i] = false;
		}

	}

}
