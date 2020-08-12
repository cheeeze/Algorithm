import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #2908 상수
 * 시작일 : 2020-08-12
 * 완료일 : ``
 * 문자열 처리
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		int x = 0;
		int y = 0;
		int t = 1;
		for(int i=0;i<3;i++) {
			x += (a.charAt(i)-'0')*t;
			y += (b.charAt(i)-'0')*t;
			t*=10;
		}
		
		if(x>y) {
			System.out.println(x);
		}else {
			System.out.println(y);
		}

	}

}
