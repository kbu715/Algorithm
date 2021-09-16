package com.day3;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] values = {3,11,15,20,21,45};
		
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 45));
		System.out.println(Arrays.binarySearch(values, 15));
		System.out.println(Arrays.binarySearch(values, 12));
		System.out.println(Arrays.binarySearch(values, 13));
		System.out.println(Arrays.binarySearch(values, 14));
		System.out.println(Arrays.binarySearch(values, 16));
		System.out.println(Arrays.binarySearch(values, 0));
		
		// -(insert point)-1 값이 리턴된다. 0때문에 0은 -값을 주면 -0은 없자나?
		// 없는 값을 찾을때
		
		System.out.println(Arrays.binarySearch(values, 1, 5, 45)); // 구간 안에서 탐색도 가능 // -5리턴
		// 1포함부터~5전까지
	}

}
