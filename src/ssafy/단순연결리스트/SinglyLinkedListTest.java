package com.ssafy.algoclass.day3;

public class SinglyLinkedListTest {

	public static void main(String[] args) {

		SinglyLinkedList list = new SinglyLinkedList();

		list.printList();
		list.addLastNode("messi");
		System.out.println(list.getLastNode());
		list.printList();
		list.addLastNode("neymar");
		list.printList();

		list.addFirstNode("ronaldo");
		list.printList();

		list.insertAfterNode(list.getNode("messi"), "mbappe");
		list.printList();

		Node target = list.getNode("messi");
		System.out.println(list.getPreviousNode(target));

		list.deleteNode("ronaldo");
		list.printList();

		list.addFirstNode("kdb");
		list.printList();
	}

}
