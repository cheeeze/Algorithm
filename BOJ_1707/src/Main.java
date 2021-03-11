import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1707 이분 그래프
 * 시작일 : 2021-03-11
 * 완료일 : ``
 * BFS
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<t;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			ArrayList<Integer>[] adj = new ArrayList[v+1];
			for(int i=0;i<=v;i++) {
				adj[i] = new ArrayList<>();
			}
			
			for(int i=0;i<e;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adj[a].add(b);
				adj[b].add(a);
			}
			
			boolean[] visited = new boolean[v+1];
			int[] checked = new int[v+1];
						
			LinkedList<Integer> q = new LinkedList<>();
			for(int k=1;k<=v;k++) {
				if(!visited[k]) {
					visited[k] = true;
					q.add(k);
					int level = 1;					
					while(!q.isEmpty()) {
						int qSize = q.size();
						for(int i=0;i<qSize;i++) {
							int x = q.poll();
							checked[x] = level%2;
							int l = adj[x].size();
							for(int j=0;j<l;j++) {
								int y = adj[x].get(j);
								if(!visited[y]) {
									visited[y] = true;
									q.add(y);
								}
							}
						}
						level++;
					}
				}
			}
			
			boolean answer = true;
			Loop : for(int i=1;i<=v;i++) {
				int size = adj[i].size();
				for(int j=0;j<size;j++) {
					if(checked[i] == checked[adj[i].get(j)]) {
						answer = false;
						break Loop;
					}
				}
			}
			
			if(answer) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
			
		}
		System.out.print(sb.toString());

	}

}

