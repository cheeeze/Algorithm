import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * BOJ #1449 수리공 항승
 * 시작일 : 2020-09-09
 * 완료일 : ``
 * Greedy
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] leak = new int[n];
		for(int i=0;i<n;i++) {
			leak[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(leak);
		int answer = 1;
		double index = leak[0]-0.5+l;
		for(int i=1;i<n;i++) {
			if(index>=(leak[i]+0.5)) {
				continue;
			}else if(index<=leak[i]-0.5) {
				answer++;
				index = leak[i]-0.5+l;
			}else {
				answer++;
				index+=l;
			}
			
		}
		System.out.println(answer);
	}

}
