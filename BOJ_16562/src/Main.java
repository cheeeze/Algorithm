import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #16562 친구비
 * 시작일 : 2020-09-01
 * 완료일 : ``
 * 유니온파인드
 */
public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		p = new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int[] v = new int[n+1];
		for(int i=1;i<=n;i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		boolean[] checked = new boolean[n+1];
		int answer = 0;
		int min = 0;
		for(int i=1;i<=n;i++) {
			if(!checked[i]) {
				checked[i] = true;
				min = v[i];
				for(int j=1;j<=n;j++) {
					if(!checked[j] && find(i)==find(j)) {
						checked[j] = true;
						if(v[j]<min) {
							min = v[j];
						}
					}
				}
				answer+=min;
			}
		}
		
		boolean check = true;
		for(int i=1;i<=n;i++) {
			if(!checked[i]) {
				check = false;
				break;
			}
		}
		
		if(!check || answer>k) {
			System.out.println("Oh no");
		}else {
			System.out.println(answer);
		}

	}
	
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px!=py) {
			p[py] = px;
		}
		
	}
	
	static int find(int x) {
		if(p[x]==x) {
			return x;
		}
		return p[x] = find(p[x]);
	}
}
