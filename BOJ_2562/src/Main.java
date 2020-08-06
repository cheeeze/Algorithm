import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BOJ #2562 최댓값
 * 시작일 : 2020-08-06
 * 완료일 : ``
 * 구현
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = 0;
		int num = 0;
		int t = 0;
		for(int i=1;i<10;i++) {
			t = Integer.parseInt(br.readLine());
			if(max<t) {
				max = t;
				num = i;
			}
		}
		System.out.println(max);
		System.out.println(num);
	}

}
