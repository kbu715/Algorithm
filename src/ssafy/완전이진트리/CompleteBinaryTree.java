package com.ssafy.algoclass.day4;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private final int SIZE;
	private int lastIndex; // 마지막에 추가된 노드의 인덱스

	public CompleteBinaryTree(int size) {
		this.SIZE = size;
		nodes = new char[size + 1];
	}

	public void add(char c) {
		if (lastIndex == SIZE) {
			return;
		}
		nodes[++lastIndex] = c;
	}

	public void bfs() { // 너비 우선 탐색
		// 탐색을 기다리는 노드들이 저장됨.
		// 배열을 관리하므로 탐색할 노드를 관리하는 인덱스를 저장!!!
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(1); // 루트노드 인덱스 저장

		int current = 0;
		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.println(nodes[current]);
			if (current * 2 <= lastIndex) // 왼쪽 자식이 있다면
				queue.offer(current * 2);
			if (current * 2 + 1 <= lastIndex) // 오른쪽 자식
				queue.offer(current * 2 + 1);
		}

	}

	public void bfs2() {
		// 탐색을 기다리는 노드들이 저장됨.
		// 배열을 관리하므로 탐색할 노드를 관리하는 인덱스를 저장!!!
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(1); // 루트노드 인덱스 저장

		int current = 0, level = 0, size = 0;
		while (!queue.isEmpty()) {
			size = queue.size();

			System.out.print("level" + level + ":");
			while (--size >= 0) {
				current = queue.poll();
				System.out.print(nodes[current]);
				if (current * 2 <= lastIndex) // 왼쪽 자식이 있다면
					queue.offer(current * 2);
				if (current * 2 + 1 <= lastIndex) // 오른쪽 자식
					queue.offer(current * 2 + 1);
			}
			System.out.println();
			++level;
		}

	}

	// 전위 순회
	public void dfsByPreOrder() {
		System.out.print("Preorder : ");
		dfsByPreOrder(1);
		System.out.println();
	}

	private void dfsByPreOrder(int current) {
		// 현재 노드 처리
		System.out.print(nodes[current] + " ");
		// 왼쪽 자식 노드 처리
		if (current * 2 <= lastIndex)
			dfsByPreOrder(current * 2);
		// 오른쪽 자식 노드 처리
		if (current * 2 + 1 <= lastIndex)
			dfsByPreOrder(current * 2 + 1);
	}

	// 중위 순회
	public void dfsByInOrder() {
		System.out.print("Inorder : ");
		dfsByInOrder(1);
		System.out.println();
	}

	private void dfsByInOrder(int current) {
		// 왼쪽 자식 노드 처리
		if (current * 2 <= lastIndex)
			dfsByInOrder(current * 2);
		// 현재 노드 처리
		System.out.print(nodes[current] + " ");
		// 오른쪽 자식 노드 처리
		if (current * 2 + 1 <= lastIndex)
			dfsByInOrder(current * 2 + 1);
	}

	// 후위 순회
	public void dfsByPostOrder() {
		System.out.print("Postorder : ");
		dfsByPostOrder(1);
		System.out.println();
	}

	private void dfsByPostOrder(int current) {
		// 왼쪽 자식 노드 처리
		if (current * 2 <= lastIndex)
			dfsByPostOrder(current * 2);
		// 오른쪽 자식 노드 처리
		if (current * 2 + 1 <= lastIndex)
			dfsByPostOrder(current * 2 + 1);
		// 현재 노드 처리
		System.out.print(nodes[current] + " ");
	}
}
