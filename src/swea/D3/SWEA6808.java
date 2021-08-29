package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 규영이와 인영이의 카드게임 D3
public class SWEA6808 {

	static boolean[] flag;
	static int[] selected;
	static int[] kyu;
	static int[] in;

	static int wCase;
	static int lCase;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			wCase = 0;
			lCase = 0;
			kyu = new int[9];
			in = new int[9];
			flag = new boolean[9];
			selected = new int[9];

			String[] temp = br.readLine().split(" ");
			for (int i = 0; i < 9; i++) {
				kyu[i] = Integer.parseInt(temp[i]);
			}
			int cnt = 0;
			boolean flag;

			// 18장의 카드 분리하기
			for (int i = 1; i <= 18; i++) {
				flag = false;
				for (int j = 0; j < 9; j++) {
					if (i == kyu[j]) {
						flag = true;
						break;
					}
				}
				if (!flag)
					in[cnt++] = i;
			}

			perm(0);

			System.out.println("#" + tc + " " + wCase + " " + lCase);
		}
	}

	private static void perm(int cnt) {
		if (cnt == 9) { // 인영이의 9!경우 중 한가지가 완성되었을때

			// 1. 게임을 진행하여 각자의 총점 구하기
			int kyuSum = 0, inSum = 0;
			for (int i = 0; i < 9; i++) {
				if (kyu[i] > selected[i]) {
					kyuSum += (kyu[i] + selected[i]);
				} else if (kyu[i] < selected[i]) {
					inSum += (kyu[i] + selected[i]);
				} else
					continue;
			}

			// 2. 이긴사람 경우의 수 카운팅

			if (kyuSum > inSum) {
				wCase++;
			} else if (kyuSum < inSum) {
				lCase++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (flag[i]) {
				continue;
			}

			flag[i] = true;
			selected[cnt] = in[i];
			perm(cnt + 1);
			flag[i] = false;
		}
	}

}
