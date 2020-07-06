import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #1673 치킨 쿠폰
 * 시작일 : 2020-07-06
 * 완료일 : ``
 * 구현, EOF 처리
 */
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			try {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());			
				int answer = n;
				
				while(n>=k) {
					int rest = n%k;
					n = n/k;
					answer+=n;
					n+=rest;					
				}
				
				System.out.println(answer);
			} catch(Exception e) {
				break;
			}	
			
		}	

	}

}
