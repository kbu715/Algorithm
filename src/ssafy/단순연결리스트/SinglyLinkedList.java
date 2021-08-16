package com.ssafy.algoclass.day3;

public class SinglyLinkedList {
	private Node head; // 헤드는 첫번째 노드를 저장

	// 첫번째 노드로 삽입하기
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head); // 새로운 노드 생성
		head = newNode;	// 리스트의 처음으로 지정
	}

	public Node getLastNode() {
		for (Node currNode = head; currNode != null; currNode = currNode.link) { // 링크 필드가 Null인 노드가 연결 리스트의 가장 마지막 노드이다.
			if (currNode.link == null) { // 자신의 뒤에 아무도 없으면 자신이 막내 // 마지막 노드 찾을때까지 이동
				return currNode;
			}
		}
		return null;
	}

	// 마지막 노드로 삽입하기
	public void addLastNode(String data) {

		if (head == null) { // 빈 리스트일때, 최초 노드 추가
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode = new Node(data); // link 필드는 자동으로 null
		lastNode.link = newNode;
	}

	// preNode 뒤에 노드 삽입하기
	public void insertAfterNode(Node preNode, String data) {
		if (preNode == null) {
			System.out.println("선행 노드가 없어 삽입이 불가능합니다.");
			return;
		}

		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;

	}

	// data를 데이터로 갖고있는 처음 만나는 노드 리턴
	public Node getNode(String data) {
		for (Node currNode = head; currNode != null; currNode = currNode.link) { 
			if (currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}

	// target의 이전 노드 찾기
	public Node getPreviousNode(Node target) {
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			if (currNode.link == target) {
				return currNode;
			}
		}
		return null;
	}

	// data를 갖고 있는 첫번째 노드 찾아 삭제
	public void deleteNode(String data) {
		Node targetNode = getNode(data);
		if (targetNode == null) {
			System.out.println("삭제할 노드가 없어서 삭제가 불가능합니다.");
			return;
		}

		Node preNode = getPreviousNode(targetNode);

		if (preNode == null) { // target이 첫번째 노드인 상황
			head = targetNode.link;
		} else { // target이 첫번째 노드가 아닌 상황
			preNode.link = targetNode.link;
		}
		targetNode.link = null;
	}

	public void printList() {
		System.out.print("L = ( ");
		for (Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data + " ");
		}
		System.out.println(")");
	}

	public boolean isEmpty() {
		return head == null;
	}
}
