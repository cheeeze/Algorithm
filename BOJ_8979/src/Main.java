import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * BOJ #8979 올림픽
 * 시작일 : 2020-07-24
 * 완료일 : 2020-08-04
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Score> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Score(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);		
		if(list.get(0).n==k) {
			System.out.println(1);
			return;
		}
		int rank = 1;
		for(int i=1;i<n;i++) {
			if(!(list.get(i).g==list.get(i-1).g && list.get(i).s==list.get(i-1).s && list.get(i).b==list.get(i-1).b)) {
				rank = i+1;
			}
			if(list.get(i).n==k) {
				break;
			}
		}
		System.out.println(rank);

	}
	
	static class Score implements Comparable<Score>{
		int n;
		int g;
		int s;
		int b;
		
		public Score(int n, int g, int s, int b) {
			super();
			this.n = n;
			this.g = g;
			this.s = s;
			this.b = b;
		}
		
		@Override
		public int compareTo(Score o) {
			if(this.g==o.g) {
				if(this.s==o.s) {
					if(this.b==o.b) {
						return 0;
					}
					return o.b-this.b;
				}
				return o.s-this.s;
			}
			return o.g-this.g;
		}
		
	}

}
