package com.ssafy.algoclass.day3;
// 연결 리스트에서 하나의 원소를 표현하는 building block
public class Node {
	// 데이터 필드 : 원소의 값을 저장
	public String data;
	// 링크 필드 : 다음 노드의 참조값을 저장
	public Node link;

	public Node(String data) {
		super();
		this.data = data;
	}

	public Node(String data, Node link) {
		this(data);
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}

}
