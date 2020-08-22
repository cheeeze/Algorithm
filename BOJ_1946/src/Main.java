import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1946 신입 사원
 * 시작일 : 2020-08-22
 * 완료일 : ``
 * 그리디
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<tcase;tc++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Apply> list = new LinkedList<>();
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				list.add(new Apply(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
			int cnt = 1;
			int lower = list.poll().b;
			while(!list.isEmpty()) {
				int t = list.poll().b;
				if(lower>t) {
					cnt++;
					lower = t;
				}
			}
			sb.append(cnt);
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}
	
	static class Apply implements Comparable<Apply>{
		int a;
		int b;
		public Apply(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Apply o) {
			return this.a-o.a;
		}
	}

}
