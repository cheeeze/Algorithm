import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #11279 최대 힙
 * 시작일 : 2020-08-28
 * 완료일 : ``
 * 힙
 */
public class Main {

	static int[] heap;
	static int size;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		heap = new int[n+2];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(br.readLine());
			if(k==0) {
				sb.append(delete());
				sb.append('\n');
			}else {
				insert(k);
			}
		}
		System.out.print(sb.toString());
	}
	
	static void insert(int x) {
		heap[++size] = x;
		int child = size;
		int parent = child/2;
		while(parent>=1 && heap[child]>heap[parent]) {
			int t = heap[parent];
			heap[parent] = heap[child];
			heap[child] = t;
			child = parent;
			parent /= 2;
		}
	}

	static int delete() {
		if(size<1) {
			return 0;
		}
		int max = heap[1];
		heap[1] = heap[size--];
		int child = 2;
		int parent = 1;
		while(child<=size) {
			if(child+1<=size && heap[child+1]>heap[child]) {
				child++;
			}
			if(heap[parent]<heap[child]) {
				int t = heap[parent];
				heap[parent] = heap[child];
				heap[child] = t;
			}
			
			parent = child;
			child = parent*2;
		}
		return max;
	}
}
