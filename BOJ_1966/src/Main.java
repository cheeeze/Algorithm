import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * BOJ #1966 프린터 큐
 * 시작일 : 2020-08-31
 * 완료일 : ``
 * 시뮬레이션
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<testcase;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			LinkedList<Doc> q = new LinkedList<>();
			int[] pr = new int[10];
			for(int i=0;i<n;i++) {
				int t = Integer.parseInt(st.nextToken());
				pr[t]++;
				q.offer(new Doc(i,t));
			}
			
			int answer = 0;
			Loop : while(!q.isEmpty()) {
				int max = 9;
				for(int i=max;i>0;i--) {
					if(pr[i]>0) {
						pr[i]--;
						max = i;
						break;
					}
				}
				boolean out = false;
				while(!out) {
					if(q.peek().prior==max) {
						answer++;
						out = true;
						if(q.peek().num==m) {
							break Loop;
						}
						q.poll();
					}else {
						q.offer(q.poll());
					}
				}			
			}
			sb.append(answer);
			sb.append('\n');
		}
		System.out.print(sb.toString());
		
	}
	
	static class Doc {
		int num;
		int prior;
		
		public Doc(int num, int prior) {
			super();
			this.num = num;
			this.prior = prior;
		}
	}

}
