import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #13305 주유소
 * 시작일 : 2020-09-11
 * 완료일 : 2020-09-12
 * 구현, (DP)
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());	
		long[] dist = new long[n];
		long[] liter = new long[n];	
		for(int i=0;i<n-1;i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			liter[i] = Long.parseLong(st.nextToken());
		}
		
		long answer = 0;
		for(int i=1;i<n;i++) {
			if(liter[i]>liter[i-1]) {
				liter[i] = liter[i-1];
			}
		}
		
		for(int i=0;i<n-1;i++) {
			answer+=dist[i]*liter[i];
		}
				
		System.out.println(answer);
	}

}
