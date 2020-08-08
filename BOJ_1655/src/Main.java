import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #1655 가운데를 말해요
 * 시작일 : 2020-07-25
 * 완료일 : 2020-08-08
 * 힙
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] maxHeap = new int[n+1];
		int[] minHeap = new int[n+1];
		int maxSize = 0;
		int minSize = 0;
		for(int i=0;i<n;i++) {
			if(maxSize>minSize) {
				minHeap[++minSize] = Integer.parseInt(br.readLine());
				heapify(minHeap,minSize,false);
			}else {
				maxHeap[++maxSize] = Integer.parseInt(br.readLine());
				heapify(maxHeap,maxSize,true);
			}
			if(minSize>0 && maxHeap[1]>minHeap[1]) {
				int max = maxHeap[1];
				int min = minHeap[1];
				delete(maxHeap,maxSize,true);
				delete(minHeap,minSize,false);
				maxHeap[maxSize] = min;
				minHeap[minSize] = max;
				heapify(minHeap,minSize,false);
				heapify(maxHeap,maxSize,true);
			}
			sb.append(maxHeap[1]);
			sb.append('\n');
		}

		System.out.println(sb.toString());
	}
	
	static void heapify(int[] arr, int size, boolean max) {
		if(max) {
			while(size>1 && arr[size/2]<arr[size]) {
				int t = arr[size/2];
				arr[size/2] = arr[size];
				arr[size] = t;
				size /= 2;
			}
		}else { //min heap
			while(size>1 && arr[size/2]>arr[size]) {
				int t = arr[size/2];
				arr[size/2] = arr[size];
				arr[size] = t;
				size /= 2;
			}
		}
	}
	
	static void delete(int[] arr, int size, boolean max) {
		if(max) {
			arr[1] = arr[size];
			size--;
			int p = 1;
			while((p*2)<=size) {
				if(p*2+1<=size && arr[p*2]<arr[p*2+1]) {
					p = p*2+1;
				}else {
					p = p*2;
				}
				if(arr[p/2]<arr[p]) {
					int t = arr[p/2];
					arr[p/2] = arr[p];
					arr[p] = t;
				}else {
					break;
				}
			}
		}else {
			arr[1] = arr[size];
			size--;
			int p = 1;
			while((p*2)<=size) {
				if(p*2+1<=size && arr[p*2]>arr[p*2+1]) {
					p = p*2+1;
				}else {
					p = p*2;
				}
				if(arr[p/2]>arr[p]) {
					int t = arr[p/2];
					arr[p/2] = arr[p];
					arr[p] = t;
				}else {
					break;
				}
			}
		}
	}
}
