package com.day11;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 6, 20, 35, 7 };
		Arrays.sort(arr);
		// 4, 6, 7, 10, 20, 35
		System.out.println(binarySearch(arr, 6));
		System.out.println(binarySearch(arr, 35));
		System.out.println(binarySearch(arr, 50)); // 없는 key
		
		System.out.println();
		
		System.out.println(Arrays.binarySearch(arr, 6));
		System.out.println(Arrays.binarySearch(arr, 35));
		System.out.println(Arrays.binarySearch(arr, 50)); // API에서는 -1을 리턴할까? // 찾아보기
	}

	// key에 해당하는 원소의 인덱스 리턴
	static int binarySearch(int[] arr, int key) {

		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = (start + end) / 2; // 중간위치
			if (arr[mid] == key) {
				return mid;
			} else if (arr[mid] < key) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		// while문 다 돌아도 못찾았다면
		return -1;
	}

}
