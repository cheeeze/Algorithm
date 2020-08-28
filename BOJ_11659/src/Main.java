import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #11659 구간 합 구하기 4
 * 시작일 : 2020-08-28
 * 완료일 : ``
 * 누적합
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int num = 0;
		int[] sum = new int[n+1];
		for(int i=1;i<=n;i++) {
			num = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1]+num;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(sum[b]-sum[a-1]);
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
