import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1929 소수 구하기
 * 시작일 : 2020-08-05
 * 완료일 : ``
 * 에라토스테네스의 체
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n+1];
		for(int i=2;i<=n;i++) {
			num[i] = i;
		}
		for(int i=2;i<=n;i++) {
			if(num[i]!=0) {
				for(int j=i+i;j<=n;j+=i) {
					num[j] = 0;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=m;i<=n;i++) {
			if(num[i]!=0) {
				sb.append(i);
				sb.append('\n');
			}
		}
		System.out.print(sb.toString());
	}

}
