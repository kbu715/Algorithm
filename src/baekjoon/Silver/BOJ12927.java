package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ12927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] temp = br.readLine().toCharArray();
		boolean[] flag = new boolean[temp.length + 1];

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == 'Y') {
				flag[i + 1] = true;
			} else {
				flag[i + 1] = false;
			}
		} // 입력끝

		int count = 0;
		if (!checkAllOff(flag)) {
			for (int i = 1; i < flag.length; i++) {
				if (flag[i] == true) {

					toggle(flag, (i));
					count++;
					// 체크
					if (checkAllOff(flag))
						break;
				}
			}
			if (!checkAllOff(flag)) {
				count = -1;
			}
		}

		System.out.println(count);
	}

	// i번 스위치는 i의 배수 번호를 가지는 전구의 상태를 모두 반전시킨다.
	private static void toggle(boolean[] array, int index) {
		for (int i = index; i < array.length; i += index) {
			array[i] = !array[i];
		}
	}

	private static boolean checkAllOff(boolean[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] == true) {
				return false;
			}
		}
		return true;
	}

}
