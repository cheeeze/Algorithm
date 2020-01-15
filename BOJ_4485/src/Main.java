import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * BOJ #4485 녹색 옷 입은 애가 젤다지?
 */
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		int testcase=1;
		while(n!=0) {
			n = Integer.parseInt(br.readLine().trim());
			if(n==0) {
				break;
			}
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}//입력 완료
			
			int[] dr = {1,-1,0,0};
			int[] dc = {0,0,1,-1};
			//인접 리스트
			ArrayList<Node>[] list = new ArrayList[n*n];
			for(int i=0;i<n*n;i++) {
				list[i] = new ArrayList<>();
			}
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					for(int d=0;d<4;d++) {
						int tr=i+dr[d];
						int tc=j+dc[d];
						if(tr<0 || tc<0 || tr>=n || tc>=n) {
							continue;
						}
						list[i*n+j].add(new Node(tr*n+tc,map[i][j]));
					}
				}
			}
			int[] dist = new int[n*n];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			pq.add(0);
			dist[0] = 0;
			
			while(!pq.isEmpty()) {
				int current = pq.poll();
				if(current==(n*n-1)) {
					break;
				}
				for(int i=0;i<list[current].size();i++) {
					int next = list[current].get(i).dest;
					int value = list[current].get(i).dis;
					
					if(dist[next]>dist[current]+value) {
						dist[next]=dist[current]+value;
						pq.add(next);
					}
				}
			}
			
			System.out.println("Problem "+testcase+": "+(dist[n*n-1]+map[n-1][n-1]));
			testcase++;
		}

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
