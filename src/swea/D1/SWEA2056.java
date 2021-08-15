package com.day9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA2056 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			String[] temp = br.readLine().split("");

			int month = Integer.parseInt((temp[4].equals("0") ? "" : temp[4]) + temp[5]);
			int day = Integer.parseInt((temp[6].equals("0") ? "" : temp[6]) + temp[7]);

			if (month < 1 || month > 12) {
				sb.append("#" + tc + " -1\n");
				continue;
			}

			boolean flag = true;

			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (day < 1 || day > 31) {
					sb.append("#" + tc + " -1\n");
					flag = false;
				}

				break;
			case 2:
				if (day < 1 || day > 28) {
					sb.append("#" + tc + " -1\n");
					flag = false;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (day < 1 || day > 30) {
					sb.append("#" + tc + " -1\n");
					flag = false;
				}
				break;
			}
			if (!flag) {
				continue;
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < 4; i++) {
				sb.append(temp[i]);
			}
			sb.append("/");
			for (int i = 4; i < 6; i++) {
				sb.append(temp[i]);
			}
			sb.append("/");
			sb.append(day < 10 ? "0" + day : day);
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
