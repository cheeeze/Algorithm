import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #10866 덱
 * 시작일 : 2020-10-09
 * 완료일 : ``
 * 자료구조 Deque
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque deque = new Deque();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String command = br.readLine();
			if(command.equals("pop_front")) {
				sb.append(deque.popFront()+"\n");
			}else if(command.equals("pop_back")) {
				sb.append(deque.popBack()+"\n");
			}else if(command.equals("size")) {
				sb.append(deque.size()+"\n");
			}else if(command.equals("empty")) {
				if(deque.isEmpty()) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}else if(command.equals("front")) {
				sb.append(deque.peekFront()+"\n");
			}else if(command.equals("back")) {
				sb.append(deque.peekBack()+"\n");
			}else if(command.substring(0,6).equals("push_f")) {
				int x = Integer.parseInt(command.substring(11));
				deque.pushFront(x);
			}else if(command.subSequence(0, 6).equals("push_b")) {
				int x = Integer.parseInt(command.substring(10));
				deque.pushBack(x);
			}		
		}
		System.out.print(sb.toString());

	}
	
	static class Node {
		int data;
		Node front;
		Node rear;
		
		public Node(int data) {
			super();
			this.data = data;
		}	
	}
	
	static class Deque {
		Node front;
		Node rear;
		
		public Deque() {
			front = null;
			rear = null;
		}
		
		void pushFront(int x) {
			Node node = new Node(x);
			if(isEmpty()) {
				front = node;
				rear = node;
				node.front = null;
				node.rear = null;
			}else {
				front.front = node;
				node.rear = front;
				node.front = null;
				front = node;
			}
		}
		
		void pushBack(int x) {
			Node node = new Node(x);
			if(isEmpty()) {
				front = node;
				rear = node;
				node.front = null;
				node.rear = null;
			}else {
				rear.rear = node;
				node.front = rear;
				node.rear = null;
				rear = node;
			}
		}
		
		int popFront() {
			if(isEmpty()) {
				return -1;
			}
			int v = front.data;
			if(front.rear==null) {
				front = null;
				rear = null;
			}else {
				front = front.rear;
				front.front = null;
			}
			return v;
		}
		
		int popBack() {
			if(isEmpty()) {
				return -1;
			}
			int v = rear.data;
			if(rear.front==null) {
				front = null;
				rear = null;
			}else {
				rear = rear.front;
				rear.rear = null;
			}
			return v;
		}
		
		int size() {
			int size = 0;
			Node temp = front;
			while(temp != null) {
				temp = temp.rear;
				size++;
			}
			return size;
		}
		
		boolean isEmpty() {
			if(front == null) {
				return true;
			}
			return false;
		}
		
		int peekFront() {
			if(isEmpty()) {
				return -1;
			}
			return front.data;
		}
		
		int peekBack() {
			if(isEmpty()) {
				return -1;
			}
			return rear.data;
		}	

	}

}
