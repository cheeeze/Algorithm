import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #10845 큐
 * 시작일 : 2020-08-24
 * 완료일 : ``
 * 큐
 */
public class Main {
	
	static int front = 0;
	static int rear = 0;
	static int[] queue = new int[10002];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String op = br.readLine();
			if(op.contains("push")) {
				int k = Integer.parseInt(op.substring(5));
				push(k);
			}else if(op.equals("pop")) {
				sb.append(pop());
				sb.append('\n');
			}else if(op.equals("size")) {
				sb.append(size());
				sb.append('\n');
			}else if(op.equals("empty")) {
				sb.append(empty());
				sb.append('\n');
			}else if(op.equals("front")) {
				sb.append(front());
				sb.append('\n');
			}else if(op.equals("back")) {
				sb.append(back());
				sb.append('\n');
			}
		}
		System.out.print(sb.toString());
	}
	
	static void push(int x) {
		queue[rear++] = x;
	}
	
	static int pop() {
		if(empty()==0) {
			return queue[front++];
		}else {
			return -1;
		}
	}
	
	static int size() {
		return rear-front;
	}
	
	static int empty() {
		if(front==rear) {
			return 1;
		}else {
			return 0;
		}
	}
	
	static int front() {
		if(empty()==0) {
			return queue[front];
		}else {
			return -1;
		}
	}
	
	static int back() {
		if(empty()==0){
			return queue[rear-1];
		}else {
			return -1;
		}
	}

}
