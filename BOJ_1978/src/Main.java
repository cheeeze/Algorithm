import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1978 소수 찾기
 * 시작일 : 2020-07-29
 * 완료일 : ``
 * 에라토스테네스의 체
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] num = new int[1001];
		for(int i=2;i<1001;i++) {
			num[i] = i;
		}
		for(int i=2;i<1001;i++) {
			if(num[i]!=0) {
				for(int j=i*2;j<1001;j+=i) {
					num[j] = 0;
				}
			}
		}
		
		int answer = 0;
		for(int i=0;i<n;i++) {
			if(num[arr[i]]!=0) {
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}
