import java.io.BufferedReader;
import java.io.InputStreamReader; 
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #2014 소수의 곱
 * 시작일 : 2020-08-28
 * 완료일 : ``
 * 우선순위 큐
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] num = new int[k];
		for(int i=0;i<k;i++) {
			num[i] = Integer.parseInt(st.nextToken());
			pq.add(num[i]);
		}
	
		for(int i=0;i<n-1;i++) {
			int t = pq.poll();
			for(int p : num) {
				if(Integer.MAX_VALUE/p < t) {
					continue;
				}
				int temp = p*t;
				pq.add(temp);	
				if(t%p==0) {
					break;
				}
			}
		}
		System.out.println(pq.poll());
	}

}
