package com.ssafy.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();

		System.out.println(queue.isEmpty() + "/" + queue.size());

		queue.offer("황선우");
		queue.offer("김연경");
		queue.offer("우상혁");
		queue.offer("여서정");
		queue.offer("신유빈");

		System.out.println(queue.poll());
		;
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek()); // peek() 과 poll()은 다르다.
		System.out.println(queue.isEmpty() + "/" + queue.size());

		while (!queue.isEmpty()) {
			System.out.println("poll()...");
			queue.poll();
		}
		System.out.println(queue.isEmpty() + "/" + queue.size());
		System.out.println(queue.peek()); // null

	}

}
