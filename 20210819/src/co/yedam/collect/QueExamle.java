package co.yedam.collect;

import java.util.LinkedList;
import java.util.Queue;

class Message {

}

public class QueExamle {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<String>();
		que.offer("Hong");
		que.offer("Hwang");
		que.offer("Park");

		while (!que.isEmpty())
			System.out.println(que.poll());

		// peek()일 경우에는 que에서 제거하지 않음.

		System.out.println("end of que");
	}
}
