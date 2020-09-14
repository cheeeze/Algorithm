import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #18870 좌표 압축
 * 시작일 : 2020-09-14
 * 완료일 : ``
 * 우선순위 큐
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		for(int i=0;i<n;i++) {
			pq.offer(new Pos(i,Integer.parseInt(st.nextToken())));
		}
		int[] answer = new int[n];
		int idx = 0;
		Pos temp = pq.poll();
		int prev = temp.num;
		answer[temp.no] = idx;
		while(!pq.isEmpty()) {
			temp = pq.poll();
			if(prev==temp.num) {
				answer[temp.no] = idx;
			}else {
				answer[temp.no] = ++idx;
				prev = temp.num;
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(answer[i]+" ");
		}
		System.out.println(sb.toString());
	}
	
	static class Pos implements Comparable<Pos>{
		int no;
		int num;
		
		public Pos(int no, int num) {
			super();
			this.no = no;
			this.num = num;
		}

		@Override
		public int compareTo(Pos o) {
			// TODO Auto-generated method stub
			return this.num-o.num;
		}
	
	}

}
