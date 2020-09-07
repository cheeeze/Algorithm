import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1037 약수
 * 시작일 : 2020-09-07
 * 완료일 : ``
 * 정수론
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int min = 1000001;
		int max = -1;
		for(int i=0;i<n;i++) {
			int k = Integer.parseInt(st.nextToken());
			if(min>k) {
				min = k;
			}
			if(max<k) {
				max = k;
			}
			
		}
		System.out.println(min*max);
	}

}
