package Study;

import java.io.*;
import java.util.*;

public class BOJ1138_Sol {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] people = new int[N + 1];
		List<Integer> list = new ArrayList<Integer>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			people[i] = Integer.parseInt(st.nextToken());

		for (int i = N; i > 0; i--) { // 큰 것부터 처리하는 방식으로 구현(작은 것들은 의미가 없다)
			list.add(people[i], i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}