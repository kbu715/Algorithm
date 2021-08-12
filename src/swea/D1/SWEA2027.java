package com.day7;

// 대각선 출력하기
public class SWEA2027 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == cnt) {
					sb.append("#");
				} else {
					sb.append("+");
				}
			}
			cnt++;
			sb.append("\n");
		}

		System.out.println(sb);
	}

}
