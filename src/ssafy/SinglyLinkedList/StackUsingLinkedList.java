package com.ssafy.algoclass.day3;

// 단순 연결리스트로 스택 자료구조를 구현해보자
// pop peek push
public class StackUsingLinkedList {

	private SinglyLinkedList list = new SinglyLinkedList();

	public Node pop() {
		Node firstNode = list.getHead();
		list.setHead(firstNode.link);
		return firstNode;
	}

	public Node peek() {
		Node firstNode = list.getHead();
		return firstNode;
	}

	public void push(Node node) {
		list.addFirstNode(node.data);
	}

	public static void main(String[] args) {

		StackUsingLinkedList stack = new StackUsingLinkedList();

		stack.push(new Node("banana"));
		stack.push(new Node("strawberry"));
		stack.push(new Node("orange"));
		stack.push(new Node("apple"));

		stack.list.printList();

		System.out.println(stack.pop());

		stack.list.printList();

		System.out.println(stack.peek());

		stack.list.printList();

	}

}
