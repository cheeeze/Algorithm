import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1516 게임 개발
 * 시작일 : 2020-08-19
 * 완료일 : 2020-08-20
 * 위상정렬
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> q = new LinkedList<>();
		LinkedList<Integer>[] adj = new LinkedList[n+1];
		int[] value = new int[n+1];
		int[] indegree = new int[n+1];
		int[] time = new int[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new LinkedList<>();
		}
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			value[i] = t;
			while(st.hasMoreElements()) {
				t = Integer.parseInt(st.nextToken());
				if(t==-1) {
					break;
				}
				adj[t].add(i);
				indegree[i]++;
			}
		}

		for(int i=1;i<=n;i++) {			
			if(indegree[i]==0) {
				q.add(i);
				time[i] = value[i];
			}
		}
		while(!q.isEmpty()) {
			int temp  = q.poll();
			int size = adj[temp].size();
			for(int i=0;i<size;i++) {
				int next = adj[temp].get(i);
				indegree[next]--;
				time[next] = Math.max(time[next], time[temp]+value[next]);
				if(indegree[next]==0) {
					q.add(next);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=n;i++) {
			sb.append(time[i]);
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
