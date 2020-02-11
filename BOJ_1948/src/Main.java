import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1948 임계경로
 * 시작일 : 2020-02-11
 * 완료일 : 2020-02-12
 * Topological Sort / BFS
 */
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());
		LinkedList<Node>[] adj = new LinkedList[n+1];
		LinkedList<Node>[] back = new LinkedList[n+1];		
		for(int i=0;i<=n;i++) {
			adj[i] = new LinkedList<>();
			back[i] = new LinkedList<>();
		}
		for(int i=0;i<m;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b,c));
			back[b].add(new Node(a,c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[n+1];
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int t = q.poll();
			Iterator<Node> it = adj[t].iterator();
			while(it.hasNext()) {
				Node node = it.next();			
				if(distance[node.dest]<distance[t]+node.dis) {
					distance[node.dest] = distance[t]+node.dis;
					q.offer(node.dest);
				}
			}
		}
		int cnt = 0;
		boolean[] visited = new boolean[n+1];
		q.offer(end);
		visited[end] = true;
		while(!q.isEmpty()) {
			int t = q.poll();
			Iterator<Node> it = back[t].iterator();
			while(it.hasNext()) {
				Node node = it.next();
				if(distance[node.dest]+node.dis==distance[t]) {
					cnt++;
					if(!visited[node.dest]) {
						visited[node.dest] = true;
						q.offer(node.dest);
					}
				}
			}
		}
		System.out.println(distance[end]);
		System.out.println(cnt);
	}
	
	static class Node{
		int dest;
		int dis;
		
		public Node(int dest, int dis) {
			super();
			this.dest = dest;
			this.dis = dis;
		}
	}

}
