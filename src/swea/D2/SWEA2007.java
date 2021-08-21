package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 패턴 마디의 길이 D2
public class SWEA2007 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {

			LinkedList<String> queue = new LinkedList<>();

			String line = br.readLine(); // 전체문장

			String[] temp = line.split("");
			String word = ""; // 이 단어가 반복됨

			queue.offer(temp[0]);
			outter: for (int j = 1; j < temp.length; j++) {
				queue.add(temp[j]);

				for (int k = 0; k < queue.size(); k++) {
					if (!queue.get(k).equals(temp[queue.size() + k])) {
						break;
					}
					if (k == queue.size() - 1) { // 마지막까지 왔으면

						for (int l = 0; l < queue.size(); l++) {
							word = word.concat(queue.get(l));
						}
						break outter;
					}
				}

			}

			System.out.println("#" + i + " " + word.length());
		}
	}

}
