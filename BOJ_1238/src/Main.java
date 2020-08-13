import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #1238 파티
 * 시작일 : 2020-08-13
 * 완료일 : ``
 * 다익스트라
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		ArrayList<Node>[] adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		int[][] map = new int[n+1][n+1];
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			adj[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		int[][] distance = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(i,0));
			distance[i][i] = 0;
			while(!pq.isEmpty()) {
				Node node = pq.poll();
				int index = node.index;
				for(int j=0;j<adj[index].size();j++) {
					Node temp = adj[index].get(j);
					if(distance[i][temp.index]>distance[i][index]+temp.cost) {
						distance[i][temp.index] = distance[i][index]+temp.cost;
						pq.offer(new Node(temp.index,distance[i][temp.index]));
					}
				}
			}
		}
		
		int max = 0;
		for(int i=1;i<=n;i++) {
			int t = distance[i][x]+distance[x][i];
			if(t>max) {
				max = t;
			}
		}
		System.out.println(max);
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
