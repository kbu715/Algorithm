/*
다행히 원래 메모리가 무슨 값이었는지 알고 있었던 원재는 바로 원래 값으로 되돌리려고 했으나 메모리 값을 바꿀 때 또 문제가 생겼다.

메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것이다.

예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.

원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산
*/

package com.day1;

import java.util.Scanner;

public class SW1289_MemoryRecovery {

	public static void main(String[] args) {
		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String s = sc.next(); // 한줄. 원래상태
			int cnt = 0; // 바꾼 횟수 저장할 변수

			// 시작이 1인 경우
			if (s.startsWith("1")) {
				cnt++;
			}
			for (int j = 0; j < s.length() - 1; j++) {
				if (s.charAt(j) != s.charAt(j + 1)) { // 이웃요소와 값이 다르다는 건 1번은 고쳐야 한다는 뜻
					cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
