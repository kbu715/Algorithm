package Study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 팰린드롬 만들기 실버4

/*
 * 1. 각 문자는 짝수로 존재해야 한다.
 * 2. 만약 홀수라면 가운데에 개수가 1개인 문자가 유일하게 올 수 있다.
 */
public class BOJ1213 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();

		int[] a = new int[26]; // 알파벳 대문자로만 이루어져있다.

		for (int i = 0; i < input.length; i++) {
			a[input[i] - 'A']++; // 정수변환
		}

		int centerIndex = 0, odd = 0; // 중앙에 올 인덱스 // 홀수개수
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0) {
				centerIndex = i;
				odd++;
			}
		}

		if ((input.length % 2 != 0 && odd > 1) || (input.length % 2 == 0 && odd > 0)) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			String answer = "";
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a[i] / 2; j++) {
					answer += (char) (i + 'A'); // 문자 변환
				}
			}
			String reversed = reverseString(answer);

			if (odd == 1)
				answer += ((char) (centerIndex + 'A'));

			answer += reversed;
			System.out.println(answer);
		}
	}

	private static String reverseString(String s) {
		return (new StringBuffer(s)).reverse().toString();
	}

}
