package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//쉬운 거스름돈 D2
public class SWEA1970 {

	static String str = "";

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			str = "";
			System.out.println("#" + tc);
			getChange(N);

			System.out.println(str);
		}
	}

	private static void getChange(int n) {
		int cnt = n / 50000;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 50000;

		cnt = n / 10000;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 10000;

		cnt = n / 5000;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 5000;

		cnt = n / 1000;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 1000;

		cnt = n / 500;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 500;

		cnt = n / 100;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 100;

		cnt = n / 50;
		str += Integer.toString(cnt).concat(" ");
		n = n - cnt * 50;

		cnt = n / 10;
		str += Integer.toString(cnt);

	}

}
