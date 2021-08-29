package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 새샘이의 7-3-5 게임 D3

public class SWEA5948 {

	static ArrayList<Integer> input;
	static int[] selected;
	static int answer;
	static HashSet<Integer> sumSet;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			input = new ArrayList<>();
			while (st.hasMoreTokens()) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			selected = new int[3];
			sumSet = new HashSet<>();
			comb(0, 0);

			Integer[] temp = new Integer[sumSet.size()];

			sumSet.toArray(temp);

			Arrays.sort(temp);

			answer = temp[temp.length - 5];

			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < selected.length; i++) {
				sum += selected[i];
			}
			sumSet.add(sum);

			return;
		}

		for (int i = start; i < input.size(); i++) {

			selected[cnt] = input.get(i);
			comb(cnt + 1, i + 1);
		}
	}

}
