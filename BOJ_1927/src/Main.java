import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
 * BOJ #1927 최소 힙
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
		int parent = size/2;
		while(heap[parent]>heap[child]) {
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
		int min = heap[1];
		heap[1] = heap[size--];
		int child = 2;
		int parent = 1;
		while(child<=size) {
			if(child+1<=size && heap[child]>heap[child+1]) {
				child++;
			}
			if(heap[child]<heap[parent]) {
				int t = heap[parent];
				heap[parent] = heap[child];
				heap[child] = t;
			}
			parent = child;
			child = parent*2;
		}		
		return min;
	}

}
