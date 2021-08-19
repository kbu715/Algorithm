package com.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자를 정렬하자 D2
public class SWEA1966 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] nums = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums);

			sb.append("#" + tc + " ");
			for (int num : nums) {
				sb.append(num + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
