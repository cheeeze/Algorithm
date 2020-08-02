import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #2075 N번째 큰 수
 * 시작일 : 2020-08-02
 * 완료일 : ``
 * 우선순위 큐
 */
public class Main_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				q.add(Integer.parseInt(st.nextToken()));
				if(q.size()>n) {
					q.poll();
				}
			}
		}
		System.out.println(q.poll());
	}

}
