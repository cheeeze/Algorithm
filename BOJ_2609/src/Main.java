import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2609 최대공약수와 최소공배수
 * 시작일 : 2020-07-26
 * 완료일 : ``
 * 유클리드 호제법
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int mul = a*b;
		if(b>a) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		while(a%b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		
		System.out.println(b+"\n"+(mul/b));

	}

}
