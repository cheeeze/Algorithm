import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #1916 최소비용 구하기
 * 시작일 : 2020-09-21
 * 완료일 : ``
 * 다익스트라, 최단 경로
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b,c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] distance = new int[n+1];
		for(int i=1;i<=n;i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		distance[start] = 0;
		pq.offer(new Node(start,0));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int index = node.index;
			int size = adj[index].size();
			for(int i=0;i<size;i++) {
				Node temp = adj[index].get(i);
				if(distance[temp.index] > distance[index]+temp.cost) {
					distance[temp.index] = distance[index]+temp.cost;
					pq.offer(new Node(temp.index,distance[temp.index]));
				}
			}
		}
		System.out.println(distance[end]);

	}
	
	static class Node implements Comparable<Node>{
		int index;
		int cost;

		public Node(int index, int cost) {
			super();
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost-o.cost;
		}

	}

}
