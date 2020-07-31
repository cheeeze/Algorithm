import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #11724 연결 요소의 개수
 * 시작일 : 2020-07-31
 * 완료일 : ``
 * 서로소 집합(Disjoint Set) - Union Find
 */
public class Main {

	static int[] p;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		boolean[] checked = new boolean[n+1];
		int answer = 0;
		for(int i=1;i<=n;i++) {
			int t = find(i);
			if(!checked[t]) {
				checked[t] = true;
				answer++;
			}
		}
		System.out.println(answer);

	}
	
	static void union(int a, int b) {
		int x = find(a);
		int y = find(b);
		p[x] = y;
	}
	
	static int find(int a) {
		if(p[a]==a) {
			return a;
		}
		return p[a] = find(p[a]);
	}

}
