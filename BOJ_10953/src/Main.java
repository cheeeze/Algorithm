import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ #10953 A+B - 6
 * 시작일 : 2021-03-02
 * 완료일 : ``
 * 입출력, 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());	
		for(int i=0;i<t;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),",");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			System.out.println(a+b);
		}

	}

}
