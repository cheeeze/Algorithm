import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #10773 제로
 * 시작일 : 2020-08-19
 * 완료일 : ``
 * 스택
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int top = -1;
		int[] arr = new int[n+1];
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(br.readLine());
			if(k==0) {
				top--;
			}else {
				top++;
				arr[top] = k;
			}
		}
		int answer = 0;
		for(int i=0;i<=top;i++) {
			answer += arr[i];
		}
		System.out.println(answer);
		
	}

}
