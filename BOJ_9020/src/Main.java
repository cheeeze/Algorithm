import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #9020 골드바흐의 추측
 * 시작일 : 2020-08-18
 * 완료일 : ``
 * 에라토스테네스의 체
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		int[] num = new int[10001];
		for(int i=2;i<=10000;i++) {
			num[i] = i;
		}
		for(int i=2;i<=10000;i++) {
			if(num[i]==0) {
				continue;
			}
			for(int j=i+i;j<=10000;j+=i) {
				num[j] = 0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int tc=0;tc<testcase;tc++) {
			int n = Integer.parseInt(br.readLine());
			int a = 0;
			int b = 0;
			for(int i=2;i<=n/2;i++) {
				if(num[i]!=0 && num[n-i]!=0) {
					if(a==0) {
						a = i;
						b = n-i;
					}else {
						int d1 =  Math.abs(a-b);
						if(Math.abs(a-b)>Math.abs(i-n+i)) {
							a = i;
							b = n-i;
						}
					}
				}
			}
			sb.append(a);
			sb.append(' ');
			sb.append(b);
			sb.append('\n');
		}
		System.out.print(sb.toString());
	}

}
