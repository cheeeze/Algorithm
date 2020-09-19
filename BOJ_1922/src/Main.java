import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #1922 네트워크 연결
 * 시작일 : 2020-09-19
 * 완료일 : ``
 * 최소 스패닝 트리, 크루스칼
 */
public class Main {

	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			pq.add(new Node(a,b,c));
		}
		
		int answer = 0;
		int cnt = 0;
		while(cnt<n-1) {
			Node temp = pq.poll();
			int u = temp.a;
			int v = temp.b;
			if(find(u)!=find(v)) {
				cnt++;
				answer+=temp.cost;
				union(u,v);
			}
		}
		
		System.out.println(answer);
	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px!=py) {
			p[py] = x;
		}
	}
	
	static int find(int x) {
		if(p[x]==x) {
			return x;
		}
		return p[x] = find(p[x]);
	}
	
	static class Node implements Comparable<Node>{
		int a;
		int b;
		int cost;

		public Node(int a, int b, int cost) {
			super();
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost-o.cost;
		}
		
	}

}
