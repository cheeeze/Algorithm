import java.util.LinkedList;
import java.util.Scanner;

/*
 * BOJ #2252 줄 세우기
 * 시작일 : 2020-02-08
 * 완료일 : 2020-02-08
 * Topological Sort
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		LinkedList<Integer>[] adj = new LinkedList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new LinkedList<>();
		}
		int[] size = new int[n+1];
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a].add(b);
			size[b]++;
		}
		
		LinkedList<Integer> q = new LinkedList<>();
		for(int i=1;i<=n;i++) {
			if(size[i]==0) {
				q.add(i);
			}
		}
		
		LinkedList<Integer> answer = new LinkedList<>();
		while(!q.isEmpty()) {
			int t = q.poll();
			answer.add(t);
			while(!adj[t].isEmpty()) {
				int x = adj[t].poll();
				size[x]--;
				if(size[x]==0) {
					q.offer(x);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!answer.isEmpty()) {
			sb.append(answer.poll()+" ");
		}
		System.out.println(sb.toString());
		
	}

}
