package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 비밀번호 D3
public class SWEA1234 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] temp = st.nextToken().toCharArray();
			LinkedList<Character> list = new LinkedList<>();

			for (int i = 0; i < N; i++) {
				list.add(temp[i]);
			} // 입력끝

			for (int i = list.size() - 1; i >= 1; i--) {
				char c1 = list.get(i);
				char c2 = list.get(i - 1);

				if (c1 == c2) {
					list.remove(i);
					list.remove(i - 1);
					i = list.size();
				}
			} // 삭제후

			System.out.print("#" + tc + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
			list.clear();
		}

	}

}
